package bo;

import bo.custom.LoginBO;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.LoginBoImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){  //private constructor
    }

    public static BOFactory getBoFactory(){
        if (boFactory == null){
            return boFactory = new BOFactory();
        }else{
            return boFactory;
        }
    }

    public  SuperBO getBo(BoType boType ){
        switch (boType){
            case LOGIN:
                return new LoginBoImpl();
            case ITEM:
                return new ItemBOImpl();
            default:
                return null;
        }
    }

    public enum BoType{
        LOGIN,ITEM
    }
}
