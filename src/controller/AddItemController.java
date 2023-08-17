package controller;

import bo.BOFactory;
import bo.custom.ItemBO;
import dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.time.LocalDate;

public class AddItemController {
    public TextField textItemId;
    public TextField textItemName;
    public TextField txtBatchNumber;
    public TextField txtItemPrice;
    public TextField txtSupplierName;
    public DatePicker pickerExpireDate;
    public TextField txtItemQty;

    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.ITEM);

    public void btnAddOnAction(ActionEvent event) {
        ItemDTO itemDTO = new ItemDTO(
                textItemId.getText(),
                textItemName.getText(),
                txtBatchNumber.getText(),
                Double.parseDouble( txtItemPrice.getText()),
                Double.parseDouble( txtItemQty.getText()),
                txtSupplierName.getText(),
                Date.valueOf(LocalDate.now())
        );

        boolean b=itemBO.saveItem(itemDTO);
        System.out.println(b);
    }
}
