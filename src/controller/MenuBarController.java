package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;
import util.ObjectPasser;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable {

    public Label txtUserFullName;
    public Label lblTime;
    public Label lblDate;
    public LocalTime currentTime;

    public void initialize(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtUserFullName.setText(ObjectPasser.userFullName);
        startClock();
        setDateFormat();
    }
    private void startClock(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            currentTime = LocalTime.now();
            lblTime.setText(currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
        }),
                new KeyFrame(Duration.seconds(1)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


    }
    private void setDateFormat() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM");
            lblDate.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}
