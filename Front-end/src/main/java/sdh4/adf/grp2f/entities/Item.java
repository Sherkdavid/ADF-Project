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
