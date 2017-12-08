package sdh4.adf.grp2f.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

public class Order implements ApplicationRESTObject {
    @Id
    int orderId;
    //May replace this with id based referencing
    @DBRef
    Customer customer;
    List<OrderLine> orderLines;
    String status;

    public Order(){}
    public Order(Customer customer, String status) {
        this.customer = customer;
        orderLines = new ArrayList<OrderLine>();
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
