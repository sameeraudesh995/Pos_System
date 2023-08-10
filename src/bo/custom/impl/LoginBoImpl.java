package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.custom.LoginDAO;

public class LoginBoImpl implements LoginBO {

    LoginDAO loginDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LOGIN);

    @Override
    public boolean checkPassword(String username, String password) {

        String passwordByUsername =  loginDAO.getPasswordByUsername(username);
       if(passwordByUsername == null){
           return false;
       } else return passwordByUsername.equals(password);

       }


}
