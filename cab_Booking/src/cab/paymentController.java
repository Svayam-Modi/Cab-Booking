package cab;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class paymentController implements Initializable {
    @FXML
    private Label Ridecost;

    @FXML
    private Label Tax;

    @FXML
    private Label Total;

    @FXML
    private Button back;

    @FXML
    private ComboBox<String> selectedPaymentMethod;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] strPayment = { "Credit/Debit Card", "Apple Pay", "Google Pay" };
        ObservableList<String> obsPaymentMethod = FXCollections.observableArrayList(strPayment);
        // 36 and 37 both should be accepted
        // button1.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
        selectedPaymentMethod.setItems(obsPaymentMethod);
        // selectedPaymentMethod.getSelectionModel().selectFirst();// set the default
        selectedPaymentMethod.setPromptText("Select Appropriate Payment Method");
    }
    
    public void dataSet(double cost,double tax,double total) {
                Ridecost.setText(String.format("$"+"%.2f", cost) );
                Tax.setText(String.format("$"+"%.2f", tax));
                Total.setText(String.format("$"+"%.2f", total));
    }
    @FXML
    public void thankyou(ActionEvent event) throws IOException {
        switch (selectedPaymentMethod.getSelectionModel().getSelectedIndex()) {
            case 0:
                {
                    Parent root = FXMLLoader.load(getClass().getResource("cardDetail.fxml"));
                    Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setTitle("Card Detail");
                    stage.setScene(scene);
                    stage.show();
                }   
               break;
               default:
                {
                    Parent root = FXMLLoader.load(getClass().getResource("thankyou.fxml"));
                    Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setTitle("Thank You");
                    stage.setScene(scene);
                    stage.show();
                }
                break;
            
        }
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cartype.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Select Car Type");
        stage.setScene(scene);
        stage.show();
    }
}
