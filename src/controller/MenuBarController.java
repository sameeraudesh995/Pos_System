package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import util.ObjectPasser;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable {

    public Label txtUserFullName;
    public Label lblTime;
    public Label lblDate;

    public void initialize(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtUserFullName.setText(ObjectPasser.userFullName);
    }

}
