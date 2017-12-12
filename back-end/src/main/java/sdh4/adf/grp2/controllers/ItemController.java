package sdh4.adf.grp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping(value = "/deleteByName/{name}",method = RequestMethod.DELETE)
    public void deleteByName(@PathVariable String name)
    {
        itemRepository.deleteByName(name);
    }
}
