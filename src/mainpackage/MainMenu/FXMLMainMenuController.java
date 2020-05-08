/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage.MainMenu;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mainpackage.server.mainserver.ServerFX;
import mainpackage.server.network.AlienClient;
import mainpackage.server.network.AlienConnectionFX;

public class FXMLMainMenuController extends Application{
    @FXML private AnchorPane MainPane1;
    @FXML private JFXTabPane TabPaneMain;
    @FXML private JFXTextArea messages;
    @FXML private JFXTextField input;
    @FXML private WebView wiki;
    
    @FXML
    void inputMessages() {
        input.setOnAction(event -> {
            String message = isServer ? "Server: " : "Client: ";
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
    
    public void initialize(URL url, ResourceBundle rb){
        final WebEngine web = wiki.getEngine();
        String urlwiki = "https://google.com";
        web.load(urlwiki);
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}