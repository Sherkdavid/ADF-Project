<<<<<<< HEAD:Front-end/src/main/java/sdh4/adf/grp2f/entities/Order.java
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
=======
package sdh4.adf.grp2f.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

@Document
public class Order implements ApplicationRESTObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String orderId;
    @Field("customer")
    Customer customer;
    @Field("inventory")
    List<OrderLine> orderLines;
    String status;

    public Order(){}
    public Order(Customer customer, String status) {
        this.customer = customer;
        orderLines = new ArrayList<>();
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
>>>>>>> 268b172d8618d0f4cc4b2e6e7e3a36b800cc2673:front-end/src/main/java/sdh4/adf/grp2f/entities/Order.java
