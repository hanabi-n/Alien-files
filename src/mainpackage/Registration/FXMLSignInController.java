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
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mainpackage.Icon.AlienIcon;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import org.apache.logging.log4j.*;


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
    private void SignInHandleButton(ActionEvent event) {
        
    }
 
////////////////////////////////////////
    @FXML
    void SignUpHandleButton() {
            buttonSignUp.setOnAction(event -> {
                buttonSignUp.getScene().getWindow().hide();
                loadSignUp();
            });
                
    }

    private void loadSignUp() {
          try {
            Parent parent = FXMLLoader.load(getClass().getResource("/mainpackage/MainMenu/FXMLMainMenu.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(parent));
            stage.showAndWait();
            //  AlienIcon.setStageIcon(stage);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
/////////////////////////////////////
    


}
//    void loadSign() {
//        
//        try {
//            Parent parent = FXMLLoader.load(getClass().getResource("/mainpackage/MainMenu/FXMLMainMenu.fxml"));
//            Stage stage = new Stage(StageStyle.DECORATED);
//            stage.setScene(new Scene(parent));
//            stage.showAndWait();
//          //  AlienIcon.setStageIcon(stage);
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }