package cab;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class rideEstimation {

    @FXML
    private Button Back;

    @FXML
    private Button book;

    @FXML
    private TextField destination;

    @FXML
    private Button reset;

    @FXML
    private TextField source;

    @FXML
    void forwardToCarType(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cartype.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Car Type");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void reset(ActionEvent event) {
        destination.clear();
        source.clear();
        source.requestFocus();
    }

}
