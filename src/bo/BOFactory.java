package bo;

import bo.custom.LoginBO;
import bo.custom.impl.LoginBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){  //private constructor
    }

    public BOFactory getBoFactory(){
        if (boFactory == null){
            return boFactory = new BOFactory();
        }else{
            return boFactory;
        }
    }

    public LoginBO getBo(BoType boType ){
        switch (boType){
            case LOGIN:
                return new LoginBOImpl();
            default:
                return null;
        }
    }

    public enum BoType{
        LOGIN
    }
}