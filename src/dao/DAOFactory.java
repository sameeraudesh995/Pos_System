package dao;

import dao.custom.LoginDAO;
import dao.custom.impl.LoginDAOImpl;

public class DAOFactory {

    public static DAOFactory daoFactory;

    public enum DAOType{
        LOGIN
    }

    public static DAOFactory getDaoFactory(){
        if(daoFactory == null) {
            return daoFactory = new DAOFactory();

        }else{
            return daoFactory;
        }
    }

    public LoginDAO getDAO(DAOType daoType){
        switch (daoType){
            case LOGIN:
                return new LoginDAOImpl();
            default:
                return null;
        }

    }
    private DAOFactory(){

    }
}
