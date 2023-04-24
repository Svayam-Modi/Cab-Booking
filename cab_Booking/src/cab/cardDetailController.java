package cab;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class cardDetailController implements Initializable {

    @FXML
    private Button payNow;

    @FXML
    private Button back;
    
    @FXML
    void onPaynow(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("thankyou.fxml"));
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Thank You");
            stage.setScene(scene);
            stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cartype.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Car Type");
        stage.setScene(scene);
        stage.show();
    }

}
