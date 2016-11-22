package com.EniacDevelopment.ControlClient.util;

import java.util.TimerTask;

import com.EniacDevelopment.ControlClient.view.StageNavigator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * Created by nickd on 10/4/2016.
 */

//Todo work out a way to find out if an player is active. http://stackoverflow.com/questions/27162374/javafx-2-user-idle-detection
public class TimeOut {
    private static Timeline timeLine;
    private static boolean isActive = false;
    private static int default_timeout = 5;

    //setTimerTimeoutTime with an given time
    public static void setTimerTimeoutTime(int minutes){
        timeLine = new Timeline(new KeyFrame(Duration.minutes(minutes), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(StageNavigator.getStageTitle() == StageNavigator.LOGIN_SCREEN){
                    return;
                }
                else {
                    StageNavigator.closeStage();
                    StageNavigator.openStage(StageNavigator.LOGIN_SCREEN);
                }
            }
        }));
        timeLine.setCycleCount(Timeline.INDEFINITE);
    }

    //setTimerTimeoutTime without an given time
    public static void setTimerTimeoutTime(){
        timeLine = new Timeline(new KeyFrame(Duration.minutes(default_timeout), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(StageNavigator.getStageTitle() == StageNavigator.LOGIN_SCREEN){
                    return;
                }
                else {
                    StageNavigator.closeStage();
                    StageNavigator.openStage(StageNavigator.LOGIN_SCREEN);
                }
            }
        }));
        timeLine.setCycleCount(Timeline.INDEFINITE);
    }

    public static void activateTimer(){
        if(timeLine.cycleDurationProperty() == null)
            setTimerTimeoutTime();
        timeLine.play();
        isActive = true;
    }

    public static void stopTimer(){
        if(!isActive) {
            return;
        }
        else{
            timeLine.stop();
            isActive = false;
        }
    }

    public static void resetTimer(){
        stopTimer();
        setTimerTimeoutTime();
        activateTimer();
    }

    public static void setDefaultTimeout(int timeout){
        default_timeout = timeout;
    }
}
