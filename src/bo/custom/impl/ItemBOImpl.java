package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

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
        String nextID="I"+ (++lastId);

        return nextID;
    }
}
