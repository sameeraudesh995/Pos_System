package dao.custom;

import dao.SuperDAO;
import entity.Item;

import java.util.ArrayList;

public interface ItemDAO extends SuperDAO {

    public boolean save(Item item);

    public String getLastItemId();

    public ArrayList<Item> getAllItems();
}
