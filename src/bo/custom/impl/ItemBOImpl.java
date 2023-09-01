package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ITEM);
    @Override
    public boolean saveItem(ItemDTO itemDTO) {
        //Create item entity
        Item item= new Item(
                itemDTO.getItemID(),
                itemDTO.getItemName(),
                itemDTO.getBatchNumber(),
                itemDTO.getPrice(),
                itemDTO.getQty(),
                itemDTO.getSupplier(),
                itemDTO.getExpireDate()
        );
        //Save item via ItemDAO
        return itemDAO.save(item);

    }

    @Override
    public String getNextId() {
        String lastItemId=itemDAO.getLastItemId();
        int lastId= Integer.parseInt(lastItemId.substring(1));
        return String.format("I%03d",++lastId);
    }

    @Override
    public ObservableList<ItemDTO> getAllItems() {
        ArrayList<Item> allItems = itemDAO.getAllItems();
        ObservableList<ItemDTO> allItemForTable = FXCollections.observableArrayList();
        for (Item a : allItems) {
            allItemForTable.add(new ItemDTO(
                    a.getItemID(),
                    a.getItemName(),
                    a.getBatchNumber(),
                    a.getPrice(),
                    a.getQty(),
                    a.getSupplier(),
                    a.getExpireDate()
            ));
        }

        return allItemForTable;

    }
}
