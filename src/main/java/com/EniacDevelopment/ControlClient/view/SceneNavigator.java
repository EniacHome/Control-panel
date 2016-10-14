package com.EniacDevelopment.ControlClient.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

/**
 * Utility class for controlling naviagtion between scenes
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 *
 * Created by nickd on 9/24/2016.
 */
public class SceneNavigator {
    //Constants that contain the file location off the *.fxml Scene files.
    public static final String ROOT_LAYOUT      = "/com/EniacDevelopment/ControlClient/view/RootLayout.fxml";
    public static final String SECURITY         = "/com/EniacDevelopment/ControlClient/view/SecurityScene.fxml";
    public static final String SENSORS          = "/com/EniacDevelopment/ControlClient/view/SensorScene.fxml";
    public static final String USERS            = "/com/EniacDevelopment/ControlClient/view/UserScene.fxml";

    //The main application layout controller.
    private static RootLayoutController rootLayoutController;

    //Stores the main controller for later use in navigation tasks.
    public static void setRootLayoutController(RootLayoutController rootLayoutController){
        SceneNavigator.rootLayoutController = rootLayoutController;
    }

    /*
    sceneHolder pane of the main application layout.
    Previously loaded scenes for the same fxml file are not cached.
    The fxml is loaded anew and a new scene node hierarchy generated
    every time this method is invoked.
     */
    public static void loadScene(String fxml){
        try{
            rootLayoutController.setScene((Node) FXMLLoader.load(SceneNavigator.class.getResource(fxml)));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}