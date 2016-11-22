package com.EniacDevelopment.ControlClient.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.StackPane;

import java.util.Stack;

/**
 * Created by nickd on 10/4/2016.
 */
public class SecuritySceneController {
    @FXML
    private StackPane securityScene;

    @FXML
    private void handleSwipeLeft(SwipeEvent event){
        SceneNavigator.loadScene(SceneNavigator.SENSORS);
    }

   @FXML
    private void handleSwipeRight(SwipeEvent event){
        SceneNavigator.loadScene(SceneNavigator.USERS);
    }

    @FXML
    private void mouseDrag(MouseDragEvent event){
        SceneNavigator.loadScene(SceneNavigator.SENSORS);
    }
}
