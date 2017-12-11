package sdh4.adf.grp2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order implements ApplicationJSONObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String orderId;
    @Field("customer")
    Customer customer;
    @Field("inventory")
    List<OrderLine> orderLines;
    OrderStatus status;

    public Order(){}
    public Order(Customer customer, OrderStatus status) {
        this.customer = customer;
        orderLines = new ArrayList<>();
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public String getId() {
        return orderId;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
