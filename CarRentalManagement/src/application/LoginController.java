package application;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private Text message;

    @FXML
    private Hyperlink newuser;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userField;

private Connection connect;
private PreparedStatement prepare;
private ResultSet result;
@FXML
public void loginAdmin() throws SQLException, IOException {
    String sql = "SELECT * FROM customer WHERE username = ? and password = ?";
    connect = DatabaseConnection.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, userField.getText());
        prepare.setString(2, passwordField.getText());
        result = prepare.executeQuery();

        Alert alert;
        if (userField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            if (result.next()) {
                alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Successfully Login!");
                alert.showAndWait();

                Parent root = FXMLLoader.load(getClass().getResource("Action.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

                // Close the current stage (optional, depending on your application flow)
                ((Stage) loginButton.getScene().getWindow()).close();
            }
        }
    } finally {
        // Make sure to close resources
        if (result != null) {
            result.close();
        }
        if (prepare != null) {
            prepare.close();
        }
        if (connect != null) {
            connect.close();
        }
    }
}
@FXML
public void NewUser() throws IOException {
	 Parent root = FXMLLoader.load(getClass().getResource("newuser.fxml"));
     Stage stage = new Stage();
     Scene scene = new Scene(root);

     stage.setScene(scene);
     stage.show();

     // Close the current stage (optional, depending on your application flow)
     ((Stage) newuser.getScene().getWindow()).close();
}
}