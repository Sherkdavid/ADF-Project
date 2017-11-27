package entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document
public class Order {
    @Id
    @GeneratedValue
    int orderId;
    //May replace this with id based referencing
    @DBRef
    Customer customer;
    List<OrderLine> orderLines;
    String status;

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
