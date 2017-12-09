<<<<<<< HEAD:Front-end/src/main/java/sdh4/adf/grp2f/entities/Item.java
package sdh4.adf.grp2f.entities;


import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

public class Item implements ApplicationRESTObject {

    @Id
    @GeneratedValue
    int item_id;
    String name;
    String description;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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
=======
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
>>>>>>> 268b172d8618d0f4cc4b2e6e7e3a36b800cc2673:front-end/src/main/java/sdh4/adf/grp2f/entities/Item.java
