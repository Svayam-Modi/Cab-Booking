package cab;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Cartype {

    @FXML
    private ToggleGroup CabType;

    @FXML
    private Button back;

    @FXML
    private Button payNow;

    @FXML
    private RadioButton rb1;

    @FXML
    private RadioButton rb2;

    @FXML
    private RadioButton rb3;

    
    public void initialize(URL url, ResourceBundle rb) {
        rb1.setToggleGroup(CabType);
        rb2.setToggleGroup(CabType);
        rb3.setToggleGroup(CabType);
    }
   
    @FXML
    public void SelectPayment(ActionEvent event) throws IOException{



        RadioButton rb = (RadioButton) CabType.getSelectedToggle();
        String type1 = ((Labeled) rb).getText();
        double cost;
        double tax;
        double total;
        switch (type1) 
        {
            case "Normal":
                cost = 15;
                tax = (cost * 13) / 100;
                total = cost + tax;
                break;
            case "SUV":
                cost = 25;
                tax = (cost * 13) / 100;
                total = cost + tax;
                break;
            case "Luxury":
                cost = 35;
                tax = (cost * 13) / 100;
                total = cost + tax;
                break;
            default:
                cost = 0;
                tax = (cost * 13) / 100;
                total = cost + tax;
                break;
        }
        FXMLLoader loader=new FXMLLoader(getClass().getResource("payment.fxml"));
        Parent root = loader.load();
        //loading Controller of payment.fxml
        paymentController pController=loader.getController();
        pController.dataSet(cost, tax, total);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Payment");
        stage.setScene(scene);
        stage.show();
    }
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
