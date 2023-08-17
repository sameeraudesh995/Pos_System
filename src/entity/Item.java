package entity;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item  {
    private String itemID;
    private String itemNane;
    private String batchNumber;
    private double price;
    private double qty;
    private String supplier;
    private Date expireDate;

}
