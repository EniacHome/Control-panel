package com.EniacDevelopment.ControlClient.view;

import com.EniacDevelopment.ControlClient.App;
import com.EniacDevelopment.ControlClient.util.TimeOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by nickd on 9/24/2016.
 */
public class RootLayoutController {
    //Holder of a switchable scene.
    @FXML
    private StackPane sceneHolder;

    //Replace the scene displayed in the sceneHolder with a new scene.
    public void setScene(Node node){
        sceneHolder.getChildren().setAll(node);
    }

    //Handle mouse input.
    @FXML
    private void handleEvent(ActionEvent event){
        if(event.getSource() == App.getPrimaryStage().getScene())
            System.out.println("TEST");
    }

    //Handle the security button.
    @FXML
    private void handleSecurityButton(ActionEvent event){
        SceneNavigator.loadScene(SceneNavigator.SECURITY);
    }

    //Handle the sensor button.
    @FXML
    private void handleSensorButton(ActionEvent event){
        SceneNavigator.loadScene(SceneNavigator.SENSORS);
    }

    //Handle the user button.
    @FXML
    private void handleUserButton(ActionEvent event){
        SceneNavigator.loadScene(SceneNavigator.USERS);
    }
}