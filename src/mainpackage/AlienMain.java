

package mainpackage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class AlienMain extends Application{
        @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/mainpackage/Registration/FXMLSignIn.fxml"));        
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.setTitle("Alien Files 2.0");
        setIcon(stage);
        stage.show();
    }

    public static void setIcon(Stage stage) {
        stage.getIcons().add(new Image("/mainpackage/Wallpapers/icon.png")); 
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
