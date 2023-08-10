package controller;

import bo.BOFactory;
import bo.custom.LoginBO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.ObjectPasser;

import java.io.IOException;

public class LoginFormController {
    public TextField txtUserName;
    public PasswordField txtPassword;

    LoginBO loginBO = BOFactory.getBoFactory().getBo(BOFactory.BoType.LOGIN);

    public void btnLoginOnClick(ActionEvent actionEvent) throws IOException {
       String username = txtUserName.getText();
       String password = txtPassword.getText();

       Boolean result = loginBO.checkPassword(username,password);
        if(Boolean.TRUE.equals(result)){
            String userFullName =  loginBO.getUserFullName(username);
            ObjectPasser.userFullName = userFullName;
            Parent load = FXMLLoader.load(getClass().getResource("../view/MenuBar.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Point Of Sale System");
            stage.show();
            Stage loginStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            loginStage.close();
       }else{
           Alert alert = new Alert(Alert.AlertType.ERROR, "Login Failed");
           alert.show();
       }
    }
}
