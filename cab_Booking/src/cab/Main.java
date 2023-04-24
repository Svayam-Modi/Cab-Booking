package cab;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
    
    public class Main extends Application {
    static int idx_cur = 0;
    static Pane  root;
    static List <Pane> panes= new ArrayList<Pane>();
    @Override
    public void start(Stage stage) throws IOException  {
      try {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Rapid Cabs");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    public static void main(String[] args) {
    launch(args);
  }
    
}
