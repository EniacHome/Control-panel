package com.EniacDevelopment.ControlClient.view;

import com.EniacDevelopment.ControlClient.security.PasswordHashing;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javax.crypto.*;

/**
 * Created by nickd on 10/4/2016.
 */
public class LoginController {
    @FXML
    PasswordField passwordField = new PasswordField();

    @FXML
    private void inputButtonHandler(ActionEvent event){
        ToggleButton pressedButton = (ToggleButton) event.getSource();
        char charInput = pressedButton.getText().toCharArray()[0];

        if(passwordField.getText().length() >= 4)
            return;

        if((charInput >= '0') && (charInput <= '9')){
            passwordField.appendText(Character.toString(charInput));
        }
    }

    //Handle the DashButton
    @FXML
    private void handleDashButton(ActionEvent event){
        passwordField.deleteNextChar();
    }

    //Handle the OKButton.
    @FXML
    private void handleOKButton(ActionEvent event){
        String hash = PasswordHashing.hmacDigest(passwordField.getText(), "key", "HmacSHA256");

        if(hash.equals("280ed91eee6eb96a2b1cf598843c1308e84623d14e4208d96c20f7e2de81315e")) {
            StageNavigator.closeStage();
        }
    }
}
