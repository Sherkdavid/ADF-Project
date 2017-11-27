package entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Document
public class Order {
    @Id
    @GeneratedValue
    int orderId;
    List<OrderLine> orderLines;
    String status;
}
