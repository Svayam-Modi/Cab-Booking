package cab;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class thankyouController {

    @FXML
    private Button Backbtn;

    @FXML
    void back(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("rideEstimation.fxml"));
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Ride Estimation");
            stage.setScene(scene);
            stage.show();
    }

}
