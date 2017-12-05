package shh4.adf.grp2.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class OrderLine {
    //May replace with id referencing
    @DBRef
    shh4.adf.grp2.entities.Item item;
    int quantity;
    public OrderLine(shh4.adf.grp2.entities.Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public shh4.adf.grp2.entities.Item getItem() {
        return item;
    }

    public void setItem(shh4.adf.grp2.entities.Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
