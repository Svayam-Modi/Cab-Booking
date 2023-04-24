package cab;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
import javafx.scene.Node;
public class loginController {

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private Button signUp;

    @FXML
    private TextField username;

    @FXML
    void forwardToWelcomePage(ActionEvent event) throws IOException {


        File file=new File("./loginCredentials.dat");
        if(file.exists())
        { 
            boolean flag =true;
            Scanner scanner =new Scanner(file);
            while (scanner.hasNextLine()&&flag) 
            {
                String s= scanner.nextLine();
                String[] sArray=s.split(",");
                if(username.getText().equals(sArray[0])&&password.getText().equals(sArray[1]))
                {
                    Parent root = FXMLLoader.load(getClass().getResource("rideEstimation.fxml"));
                    Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setTitle("Ride Estimate");
                    stage.setScene(scene);
                    stage.show();
                    break;
                }
                else
                {
                    if(scanner.hasNextLine())
                    {
                        continue;
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Login Failed");
                        alert.setHeaderText("Please enter valid username");
                        alert.setContentText("Please enter valid username and Password!");
                        alert.showAndWait();
                    }
                    
                }
                continue;
            }
            scanner.close();
        }
        
    }
    @FXML
    void forwardToSignUpPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
    
    }

}