package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class ActionController {

	  
    @FXML
    private void handleUpdateButtonAction(ActionEvent event) {
        try {
            // Load the Update page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Update.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Update page
            Stage stage = new Stage();
            stage.setTitle("Update Page");
            stage.setScene(new Scene(root));

            // Show the Update page
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    @FXML
    private void handleReserveButtonAction(ActionEvent ev) {
        try {
            // Load the Update page FXML file
        	 Parent root = FXMLLoader.load(getClass().getResource("Reserve.fxml"));
             Stage stage = new Stage();
             Scene scene = new Scene(root);

             stage.setScene(scene);
             stage.show();

             
            
        } catch (IOException e) {
            e.printStackTrace();
           
        }
    }
}