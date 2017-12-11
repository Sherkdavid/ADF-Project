package sdh4.adf.grp2.entities;

public class OrderLine {
    Item item;
    int quantity;
    public OrderLine(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public OrderLine(){}

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
