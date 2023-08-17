package dao;

import dao.custom.ItemDAO;
import dao.custom.LoginDAO;
import dao.custom.impl.ItemDAOImpl;
import dao.custom.impl.LoginDAOImpl;

public class DAOFactory {

    public static DAOFactory daoFactory;

    public enum DAOType{
        LOGIN,ITEM
    }

    public static DAOFactory getDaoFactory(){
        if(daoFactory == null) {
            return daoFactory = new DAOFactory();

        }else{
            return daoFactory;
        }
    }

    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){
            case LOGIN:
                return new LoginDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            default:
                return null;
        }

    }
    private DAOFactory(){

    }
}
