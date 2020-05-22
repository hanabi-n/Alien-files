/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage.Registration;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import mainpackage.database.DataBaseManager;

/**
 *
 * @author Hanabi
 */
public class FXMLSignUpController {
    @FXML
    private AnchorPane SignUp;

    @FXML
    private JFXTextField firstNameText;

    @FXML
    private JFXTextField lastNameText;

    @FXML
    private JFXTextField loginText;

    @FXML
    private JFXPasswordField passwordText;

    @FXML
    private JFXPasswordField enterPasswordText;

    @FXML
    private JFXRadioButton femaleCheck;

    @FXML
    private JFXRadioButton maleCheck;

    @FXML
    private JFXRadioButton alienCheck;

    @FXML
    private JFXButton signUpButton;

    @FXML
    void SignUpHandleButton() {
        DataBaseManager dbManager = new DataBaseManager();
        signUpButton.setOnAction(event -> {
//            if(passwordText.getText().equals(enterPasswordText.getText())){
            dbManager.addUser(firstNameText.getText(), lastNameText.getText(), loginText.getText(), passwordText.getText(), "alien");
//            }else{
//                passwordText.getStyleClass().add("warning");
//                enterPasswordText.getStyleClass().add("warning");
//            }
        }); 
    }
}


    
