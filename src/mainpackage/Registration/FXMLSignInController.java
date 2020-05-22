/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage.Registration;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static mainpackage.AlienMain.setIcon;
import mainpackage.database.DataBaseManager;
import mainpackage.database.Users;


/**
 *
 * @author Hanabi
 */
public class FXMLSignInController{
    @FXML private JFXTextField name;
    @FXML private JFXPasswordField password;
    @FXML private JFXButton buttonLogin;
    @FXML private JFXButton buttonSignUp;
    
        
    @FXML
    private void SignInHandleButton() {
        buttonLogin.setOnAction(event->{
            String nameText = name.getText().trim();
            String passwordText = password.getText().trim();
                     
            if(nameText.equals("admin") && passwordText.equals("admin") ){
                  buttonLogin.getScene().getWindow().hide();
                   loadWindow("/mainpackage/MainMenu/FXMLMainMenu.fxml");
                //loginUser(nameText, passwordText); 
                   
            }else{
                System.out.println("Error");
//                name.getStyleClass().add("warning");
//                password.getStyleClass().add("warning");               
            }
        });
    }
 ///////////////////////////////////////
    private void loginUser(String nameText, String passwordText){
        DataBaseManager manager = new DataBaseManager();
        Users user = new Users();
        user.setName(nameText);
        user.setPassword(passwordText);
        ArrayList<Users> result  = manager.getAllusers();
        
        int counter = 0;
        while(!result.isEmpty()){
            counter++;
        }
        
        if(counter >= 1){
            loadWindow("/mainpackage/MainMenu/FXMLMainMenu.fxml");
        }
//        manager.getAllusers();
        
    }
////////////////////////////////////////
    @FXML
    void SignUpHandleButton() {
            buttonSignUp.setOnAction(event -> {
                buttonSignUp.getScene().getWindow().hide();
                loadWindow("/mainpackage/Registration/FXMLSignUp.fxml");
            });             
    }
   //////////////////////////////
    private void loadWindow(String window){    
          try {
            Parent parent = FXMLLoader.load(getClass().getResource(window));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(parent));
            stage.setTitle("Alien Files 2.0");
            setIcon(stage);
            stage.showAndWait();           
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    ///////////////////////////////////////
    public static void setIcon(Stage stage) {
        stage.getIcons().add(new Image("/mainpackage/Wallpapers/icon.png")); 
    }
    
    
    
    
    
    
    
    
    
    
}
