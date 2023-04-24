package cab;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signUpController {

    
    @FXML
    private Button back;

    @FXML
    private PasswordField confirmPasswordSignUp;

    @FXML
    private TextField email;

    @FXML
    private TextField mobilenum;

    @FXML
    private TextField name;

    @FXML
    private PasswordField passwordSignUp;

    @FXML
    private Button signUpData;

    @FXML
    private Button reset;

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void addSignUp(ActionEvent event) throws IOException {
        
        if(passwordSignUp.getText().equals(confirmPasswordSignUp.getText()))
        {
            Parent root = FXMLLoader.load(getClass().getResource("rideEstimation.fxml"));
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Ride Estimate");
            stage.setScene(scene);
            stage.show();

            try(FileWriter fileWriter = new FileWriter("loginCredentials.dat", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);) 
            {
                printWriter.println(email.getText()+","+passwordSignUp.getText()+","+name.getText()+","+mobilenum.getText());
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sign up Failed");
            alert.setHeaderText("Password Does not Match");
            alert.setContentText("Please re-enter valid Password!");
            alert.showAndWait();    
            confirmPasswordSignUp.clear();
            passwordSignUp.clear();
            passwordSignUp.requestFocus();
        }

        

        // // PrintWriter fileOut ;
        // // fileOut = new PrintWriter(new BufferedWriter(new FileWriter("cab_Booking/Signup.txt", true)));
        // // fileOut.println(name.getText()+","+email.getText()+","+mobilenum.getText()+","+passwordSignUp.getText());
        // // fileOut.close();
        // try(FileWriter fileWriter = new FileWriter("cab_Booking/loginCredentials.dat", true);
        // PrintWriter printWriter = new PrintWriter(fileWriter);) 
        // {
        //     printWriter.println(email.getText()+","+passwordSignUp.getText()+","+name.getText()+","+mobilenum.getText());
        // }
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
        confirmPasswordSignUp.clear();
        passwordSignUp.clear();
        email.clear();
        mobilenum.clear();
        name.clear();
        email.requestFocus();
    }
}
