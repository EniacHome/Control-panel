package com.EniacDevelopment.ControlClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import com.EniacDevelopment.ControlClient.view.SceneNavigator;
import com.EniacDevelopment.ControlClient.view.StageNavigator;
import com.EniacDevelopment.ControlClient.view.RootLayoutController;
import com.EniacDevelopment.ControlClient.util.TimeOut;;


/**
 * Main application that manages the startup procedure of the application.
 * <p>
 * Created by nickd on 9/23/2016.
 */
public class App extends Application {
    private static Stage mainStage; //Static copy of the stage that is set on startup and is used for creating overlayStages.

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("EniacHome 2.0"); //Set the title of the stage.
        stage.initStyle(StageStyle.UNDECORATED); //Makes the standard top menu bar is disabled.
        stage.setScene(createScene(loadRootLayout())); //create a the start (main) scene.
        mainStage = stage; //Copy the stage into mainStage.
        stage.show();

        StageNavigator.openStage(StageNavigator.LOGIN_SCREEN); //Open the login screen

        TimeOut.setTimerTimeoutTime(1);
        TimeOut.activateTimer();
    }

    /*
    Loads the rootLayout fxml layout.
    Sets up the scene switching com.EniacDevelopment.ControlClient.view.SceneNavigator.
    Loads the first scene into the fxml layout.
     */
    private Pane loadRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane rootLayout = (Pane) loader.load(getClass().getResourceAsStream(SceneNavigator.ROOT_LAYOUT));

        RootLayoutController rootLayoutController = loader.getController();

        SceneNavigator.setRootLayoutController(rootLayoutController);
        SceneNavigator.loadScene(SceneNavigator.SECURITY);

        return rootLayout;
    }

    //Creates the main application scene.
    private Scene createScene(Pane rootLayout){
        Scene scene = new Scene(rootLayout);

        //scene.getStylesheets().setAll(getClass().getResource("/Eniac/Home/view/Vista.css").toExternalForm());

        return scene;
    }

    /*
    Get the primary stage.
     */
    public static Stage getPrimaryStage(){
        return mainStage;
    }

    public static void main(String[] args) { launch(args);}
}