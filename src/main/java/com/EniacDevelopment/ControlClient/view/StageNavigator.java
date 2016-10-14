package com.EniacDevelopment.ControlClient.view;

import com.EniacDevelopment.ControlClient.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Utilty class for navigating different overlay stages.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 *
 * NOTE*: Only one overlay stage at the time kan be opened.
 *
 * Created by nickd on 10/4/2016.
 */
public class StageNavigator {
    private static Stage overlayStage;

    //Constants that contain the file location of the *.fxml Stage files.
    public static final String LOGIN_SCREEN         = "/com/EniacDevelopment/ControlClient/view/Login.fxml";
    public static final String TIMER                = "/com/EniacDevelopment/ControlClient/view/TimerScene.fxml";
    public static final String ENABLE_ALARM         = "/com/EniacDevelopment/ControlCleint/view/AlarmQuickSettings.fxml";
    public static final String SENSOR_SETTINGS      = "/com/EniacDevelopment/ControlClient/view/SensorSettingsScene.fxml";
    public static final String SECURITY_SETTINGS    = "/com/EniacDevelopment/ControlClient/view/SecuritySettingsScene.fxml";
    public static final String USER_SETTINGS        = "/com/EniacDevelopment/ControlClient/view/UserSettingsScene.fxml";
    public static final String QUICK_PASSWORD       = "/com/EniacDevelopment/ControlClient/view/QuickPasswordScene.fxml";

    /*
    Method that opens an new child stage.
    This method uses the primary stage used in de start method
    in the main App.
     */
    public static void openStage(String fxml) {
        try{
            FXMLLoader loader = new FXMLLoader(); //Create a new FXMLloader.
            loader.setLocation(StageNavigator.class.getResource(fxml));
            Pane pane = (Pane) loader.load();

            //Create the stage.
            overlayStage = new Stage();
            overlayStage.setTitle(fxml);
            overlayStage.initModality(Modality.WINDOW_MODAL);
            overlayStage.initStyle(StageStyle.UNDECORATED); //Removes the default menu bar.
            overlayStage.initOwner(App.getPrimaryStage());
            Scene overlayScene = new Scene(pane);
            overlayStage.setScene(overlayScene);

            overlayStage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    public static void closeStage(){
        if(!(overlayStage.isShowing()))
            return;

        try{
            overlayStage.setTitle("");
            overlayStage.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getStageTitle(){
        return overlayStage.getTitle();
    }


}
