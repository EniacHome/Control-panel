package com.EniacDevelopment.ControlClient.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Created by nickd on 10/4/2016.
 */
public class LoginController {
    @FXML
    PasswordField passwordField = new PasswordField();

    @FXML
    private void inputButtonHandler(ActionEvent event){
        ToggleButton pressedButton = (ToggleButton) event.getSource();
        char test[] = pressedButton.getText().toCharArray();

        if(passwordField.getText().length() >= 4)
            return;

        switch (test[0]){
            case('1'):
                passwordField.appendText("1");
                break;
            case('2'):
                passwordField.appendText("2");
                break;
            case('3'):
                passwordField.appendText("3");
                break;
            case('4'):
                passwordField.appendText("4");
                break;
            case('5'):
                passwordField.appendText("5");
                break;
            case('6'):
                passwordField.appendText("6");
                break;
            case('7'):
                passwordField.appendText("7");
                break;
            case('8'):
                passwordField.appendText("8");
                break;
            case('9'):
                passwordField.appendText("9");
                break;
            case('0'):
                passwordField.appendText("0");
                break;
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
        StageNavigator.closeStage();
    }

}
