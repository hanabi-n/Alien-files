/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage.MainMenu;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static mainpackage.AlienMain.setIcon;
import mainpackage.server.mainserver.ServerFX;
import mainpackage.server.network.AlienClient;
import mainpackage.server.network.AlienConnectionFX;

public class FXMLMainMenuController extends Application{
    @FXML private AnchorPane MainPane1;
    @FXML private JFXTabPane TabPaneMain;
    @FXML private JFXTextArea messages;
    @FXML private JFXTextField input;
    @FXML private WebView wiki;
    @FXML private MenuItem LogOut;
    @FXML private JFXButton wikipedia;
    @FXML private JFXButton reddit;
    @FXML private JFXButton lenin;
    
///////////////////////////////////////////
    @FXML
    void handleLenin(ActionEvent event) {
         WebEngine webEngine = wiki.getEngine();
         String url = "https://cyberleninka.ru";
         webEngine.load(url);
    }
    
    @FXML
    void handleReddit(ActionEvent event) {
         WebEngine webEngine = wiki.getEngine();
         String url = "https://www.reddit.com";
         webEngine.load(url);
    }

    @FXML
    void handleWiki(ActionEvent event) {
         WebEngine webEngine = wiki.getEngine();
         String url = "https://ru.wikipedia.org";
         webEngine.load(url);
    }

/////////////////////////////////////////////
    @FXML
    void inputMessages() {
        input.setOnAction(event -> {
            String message = isServer ? "Server: " : "User: ";
            message += input.getText();
            input.clear();

            messages.appendText(message + "\n");

            try {
                connection.send(message);
            }
            catch (Exception e) {
                messages.appendText("Failed to send\n");
            }
        });
    }
    
    private final boolean isServer = false;

    private final AlienConnectionFX connection = isServer ? createServer() : createClient();
    
    private AlienConnectionFX createServer() {
        return new ServerFX(10444, data -> {
            Platform.runLater(() -> {
                messages.appendText(data.toString() + "\n");
            });
        });  }

    private AlienConnectionFX createClient() {
        return new AlienClient("192.168.1.107", 10444, data -> {
            Platform.runLater(() -> {
                messages.appendText(data.toString() + "\n");
            });
        });
    }
    
    @Override
    public void init() throws Exception {
        connection.startConnection();
    }
    @Override
    public void stop() throws Exception {
        connection.closeConnection();
    }
/////////////////////////////////////////////////////
    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        launch(args);
    }

/////////////////////////////////////////////////////////////
   private Stage getStage() {
            return (Stage) MainPane1.getScene().getWindow();
   }    

    @FXML
    private void handleMenuExit(ActionEvent event) {
        getStage().close();
    }
      
   @FXML
    private void handleMenuFullScreen(ActionEvent event) {
        Stage stage = getStage();
        stage.setFullScreen(!stage.isFullScreen());
    }
    
    @FXML
    void handleMenuAbouUs(ActionEvent event) {
         
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/mainpackage/MainMenu/FXMLAboutUs.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(parent));
            stage.setTitle("About Us");
            setIcon(stage);
            stage.showAndWait();
            

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    void handleLogOut(ActionEvent event) {
        getStage().close();
         
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/mainpackage/Registration/FXMLSignIn.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);   
            stage.setScene(new Scene(parent));
            stage.setTitle("Alien Files 2.0");
            
            setIcon(stage);
            stage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public static void setIcon(Stage stage) {
        stage.getIcons().add(new Image("/mainpackage/Wallpapers/icon.png")); 
    }
    
    
    
    
    
    
    
    
    
}
