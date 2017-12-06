package sdh4.adf.grp2f.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class OrderLine {
    //May replace with id referencing
    @DBRef
    Item item;
    int quantity;
    public OrderLine(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
