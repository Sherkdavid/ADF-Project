package sdh4.adf.grp2f.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "items")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements ApplicationRESTObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String itemId;
    String name;
    String description;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
