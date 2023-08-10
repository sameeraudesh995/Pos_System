package controller;

import bo.BOFactory;
import bo.custom.LoginBO;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginFormController {
    public TextField txtUserName;
    public PasswordField txtPassword;

    LoginBO loginBO = BOFactory.getBoFactory().getBo(BOFactory.BoType.LOGIN);

    public void btnLoginOnClick(ActionEvent actionEvent) {
       String username = txtUserName.getText();
       String password = txtPassword.getText();

       boolean result = loginBO.checkPassword(username,password);
    }
}
