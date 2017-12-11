package sdh4.adf.grp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdh4.adf.grp2.entities.Item;
import sdh4.adf.grp2.repositories.ItemRepository;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {
    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/all")
    public List<Item> findAll()
    {
        return itemRepository.findAll();
    }

    @GetMapping("/findByName/{name}")
    public Item findByName(@PathVariable String name)
    {
        return itemRepository.findItemByName(name);
    }
    @GetMapping("/findByDescription/{description}")
    public Item findByDescription(@PathVariable String description)
    {
        return itemRepository.findItemByDescription(description);
    }
    @GetMapping("/deleteByName/{name}")
    public void deleteByName(@PathVariable String name)
    {
        itemRepository.deleteByName(name);
    }
}
