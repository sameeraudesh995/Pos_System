package bo.custom;

import bo.SuperBO;
import dto.ItemDTO;
import javafx.collections.ObservableList;


public interface ItemBO extends SuperBO {
    public boolean saveItem(ItemDTO itemDTO);

    public String getNextId();

    public ObservableList<ItemDTO> getAllItems();

}
