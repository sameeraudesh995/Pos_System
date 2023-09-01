package controller;

import bo.BOFactory;
import bo.custom.ItemBO;
import dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

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
    public TableColumn colItemId;
    public TableColumn colItemName;
    public TableColumn colBatchNo;
    public TableColumn colItemQuantity;
    public TableColumn colItemPrice;
    public TableColumn colSupplier;
    public TableColumn colExpDate;
    public TableView tblItem;

    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.ITEM);

    public void initialize(){
        textItemId.setText(itemBO.getNextId());

    }

    public void btnAddOnAction(ActionEvent event) {

        boolean validation=true;
        if(txtItemPrice.getText().isEmpty()||
                textItemName.getText().isEmpty()||
                txtBatchNumber.getText().isEmpty() ||
                txtSupplierName.getText().isEmpty() ||
                txtItemQty.getText().isEmpty() ||
                textItemId.getText().isEmpty() ||
                pickerExpireDate.getEditor().getText().isEmpty()
        ){
            validation=false;

        }

        if(validation){
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
        }else{
            System.out.println("All field are not filed");

        }

    }

    public void txtPriceOnKeyReleased(KeyEvent keyEvent) {
        if(txtItemPrice.getText().isEmpty()){
            txtItemPrice.setPromptText("Can't Keep empty");
            txtItemPrice.setStyle("-fx-prompt-text-fill: red;" + "-fx-border-color: red");

            }
        else if(txtItemPrice.getText().matches("^[0-9]*")){
            txtItemPrice.setStyle( "-fx-border-color: blue");
        }
        else{
            txtItemPrice.setStyle("-fx-border-color: red");
            System.out.println("Can't input letters");



        }

    }
}
