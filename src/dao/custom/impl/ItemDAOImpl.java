package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import entity.Item;

import java.sql.SQLException;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item item) {
        try {
            return CrudUtil.executeUpdate("INSERT INTO items VALUES(?,?,?,?,?,?,?)",
                    item.getItemID(),
                    item.getItemNane(),
                    item.getBatchNumber(),
                    item.getPrice(),
                    item.getQty(),
                    item.getSupplier(),
                    item.getExpireDate()
                    );
        } catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();

        }
        return true;
    }
}
