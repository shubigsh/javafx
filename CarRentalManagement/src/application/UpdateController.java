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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;



public class UpdateController implements Initializable{

    @FXML
    private Button btdelete;

    @FXML
    private Button btinsert;

    @FXML
    private Button btupdate;

    @FXML
    private TableColumn<Car, Integer> colcarid;

    @FXML
    private TableColumn<Car, String> colcarname;

    @FXML
    private TableColumn<Car,String > colcolor;

    @FXML
    private TableColumn<Car, Integer> colemployee;

    @FXML
    private TableColumn<Car, String> colmodel;

    @FXML
    private TableColumn<Car, String> colplate;

    @FXML
    private TableColumn<Car, String> colstatus;

    @FXML
    private TableColumn<Car, Integer> colyear;

    @FXML
    private TableView<Car> table;
    
    @FXML
    private TextField tfcarid;

    @FXML
    private TextField tfcarname;

    @FXML
    private TextField tfcolor;

    @FXML
    private TextField tfempid;

    @FXML
    private TextField tfmodel;

    @FXML
    private TextField tfplate;

    @FXML
    private TextField tfstatus;

    @FXML
    private TextField tfyear;
    @FXML
    private void insertButton() {
    	String query = "insert into cars values("+tfcarid.getText()+",'"+tfcarname.getText()+"','"+tfmodel.getText()+"','"+tfcolor.getText()+"','"+tfyear.getText()+"','"+tfplate.getText()+"','"+tfempid.getText()+"','"+tfstatus.getText()+"')";
    	executeQuery(query);
    	showCars();
    }
    
  
    @FXML 
    private void updateButton() {
    String query = "UPDATE cars SET car_name='"+tfcarname.getText()+"',model='"+tfmodel.getText()+"',color='"+tfcolor.getText()+"',Year='"+tfyear.getText()+"', plate_no='"+tfplate.getText()+"',emp_id='"+tfempid.getText()+"',Status='"+tfstatus.getText()+"' WHERE car_id='"+tfcarid.getText()+"'";
    executeQuery(query);
	showCars();
    }
    
    @FXML
    private void deleteButton() {
    	String query = "DELETE FROM cars WHERE car_id="+tfcarid.getText()+"";
    	executeQuery(query);
    	showCars();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		showCars();
	}
	 public Connection getConnection() {
	        Connection conn;
	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental", "root", "1234567890");
	            return conn;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 public void executeQuery(String query) {
	        Connection conn = getConnection();
	        Statement st;
	        try {
	            st = conn.createStatement();
	            st.executeUpdate(query);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public ObservableList<Car> getCarsList() {
	        ObservableList<Car> carsList = FXCollections.observableArrayList();
	        Connection connection = getConnection();
	        String query = "SELECT * FROM cars";
	        Statement st;
	        ResultSet rs;

	        try {
	            st = connection.createStatement();
	            rs = st.executeQuery(query);
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

	    public void showCars() {
	    	 ObservableList<Car> list = getCarsList();

		        colcarid.setCellValueFactory(new PropertyValueFactory<>("car_id"));
		        colcarname.setCellValueFactory(new PropertyValueFactory<>("car_name"));
		        colcolor.setCellValueFactory(new PropertyValueFactory<>("color"));
		        colemployee.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
		        colmodel.setCellValueFactory(new PropertyValueFactory<>("model"));
		        colplate.setCellValueFactory(new PropertyValueFactory<>("plate_no"));
		        colstatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
		        colyear.setCellValueFactory(new PropertyValueFactory<>("Year"));


		        table.setItems(list);
	    }
	}


