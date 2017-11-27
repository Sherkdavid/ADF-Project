package entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document
public class Item {
    @Id
    @GeneratedValue
    int item_id;
    String name;
    String description;
}
