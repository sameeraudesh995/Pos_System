package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import util.ObjectPasser;

import java.io.IOException;
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
    public AnchorPane playgroundAnchorPane;

    public void initialize(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtUserFullName.setText(ObjectPasser.userFullName);
        startClock();

    }
    private void startClock(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            currentTime = LocalTime.now();
            lblTime.setText(currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM uu");
            lblDate.setText(LocalDateTime.now().format(formatter));
        }),
                new KeyFrame(Duration.seconds(1)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    public void addItemOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/AddItemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        playgroundAnchorPane.getChildren().clear();
        playgroundAnchorPane.getChildren().add(load);

        
    }
}
