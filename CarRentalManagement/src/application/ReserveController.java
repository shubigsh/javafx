package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ReserveController implements Initializable {

    @FXML
    private TableView<Car> Table;

    @FXML
    private Button book;

    @FXML
    private TableColumn<Car, String> colcolor;

    @FXML
    private TableColumn<Car, Integer> colemp;

    @FXML
    private TableColumn<Car, Integer> colid;

    @FXML
    private TableColumn<Car, String> colmodel;

    @FXML
    private TableColumn<Car, String> colname;

    @FXML
    private TableColumn<Car, String> colplate;

    @FXML
    private TableColumn<Car, String> colstatus;

    @FXML
    private TableColumn<Car, String> colyear;

    @FXML
    private TextField input;


public ObservableList<Car> getCarsList() {
	        ObservableList<Car> carsList = FXCollections.observableArrayList();
	        Connection connection = connectDb();
	        String query = "SELECT * FROM cars";
	        Statement st;
	        ResultSet rs;

	        try {
	            st = connection.createStatement();
	            rs = ((java.sql.Statement) st).executeQuery(query);
	            Car car;
	            while (rs.next()) {
	                car = new Car(rs.getInt("car_id"), rs.getString("car_name"), rs.getString("model"), rs.getString("color"), rs.getInt("year"), rs.getString("plate_no"), rs.getInt("emp_id"),rs.getString("status"));
	                carsList.add(car);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return carsList;
	    }
@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
				showCars();
}

	    public void showCars() {
	        ObservableList<Car> list = getCarsList();
	        

	        colid.setCellValueFactory(new PropertyValueFactory<>("car_id"));
	        colname.setCellValueFactory(new PropertyValueFactory<>("car_name"));
	        colcolor.setCellValueFactory(new PropertyValueFactory<>("color"));
	        colemp.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
	        colmodel.setCellValueFactory(new PropertyValueFactory<>("model"));
	        colplate.setCellValueFactory(new PropertyValueFactory<>("plate_no"));
	        colstatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
	        colyear.setCellValueFactory(new PropertyValueFactory<>("Year"));


	        Table.setItems(list);

	    }
	    public static Connection connectDb() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/car_rental","root","1234567890");
	            return connect;
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        return null;}
	    public void executeQuery(String query) {
	        Connection conn = connectDb();
	        Statement st;
	        try {
	            st = conn.createStatement();
	            st.executeUpdate(query);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @FXML
	    private void handleBookButtonAction() {
	        try {
	            String enteredCarIdText = input.getText();

	            // Validate that enteredCarIdText is not empty and is a number
	            if (!enteredCarIdText.isEmpty() && enteredCarIdText.matches("\\d+")) {
	                int enteredCarId = Integer.parseInt(enteredCarIdText);

	                // Find the selected car in the database
	                Car selectedCar = null;

	                Connection connection = connectDb();
	                String query = "SELECT * FROM cars WHERE car_id = ?";
	                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                    preparedStatement.setInt(1, enteredCarId);
	                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                        if (resultSet.next()) {
	                            selectedCar = new Car(
	                                    resultSet.getInt("car_id"),
	                                    resultSet.getString("car_name"),
	                                    resultSet.getString("model"),
	                                    resultSet.getString("color"),
	                                    resultSet.getInt("year"),
	                                    resultSet.getString("plate_no"),
	                                    resultSet.getInt("emp_id"),
	                                    resultSet.getString("status")
	                            );
	                        }
	                    }
	                }

	                // Update the status to "Reserved"
	                if (selectedCar != null) {
	                    selectedCar.setStatus("Reserved");
	                    
	                    // Update the database with the new status
	                    updateStatusInDatabase(selectedCar);
	                    showCars();
	                } else {
	                    // Handle case where car_id is not found
	                    System.out.println("Car not found with ID: " + enteredCarId);
	                }

	                connection.close();
	            } else {
	                // Handle case where entered text is not a valid number
	                System.out.println("Invalid car ID format");
	            }
	        } catch (SQLException | NumberFormatException e) {
	            // Handle database or number format exception
	            e.printStackTrace();
	        }
	    }

	    private void updateStatusInDatabase(Car car) {
	        try {
	            Connection connection = connectDb();
	            String query = "UPDATE cars SET status = 'Reserved' WHERE car_id = ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setInt(1, car.getCar_id());
	                preparedStatement.executeUpdate();
	            }
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
}


	

