package sdh4.adf.grp2.entities.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequestMapping("/template.item")
class ItemController {
    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/")
    public String doWelcomeWithParams(Model model)
            {
            return "index";
            }
    /*
    * An example of using a path variable.
    * localhost:8080/usingParameter?name=Cliona will add Cliona to the welcome
    * localhost:8080/usingParameter uses the default value of To You!
    */
    @GetMapping("/usingParameter")
    public String doWelcomeWithParams(@RequestParam(value="name", defaultValue="To You!")String name, Model model)
            {
            String sentence = "Welcome " + name;
            model.addAttribute("messages", sentence);
            return "Parameter";
            }
    @GetMapping("/displayAll")
    public String displayAll(Model model)
            {
            List<Item> i = itemRepository.findAll();
            model.addAttribute("item", i);
            return "displayAll";
            }

    @GetMapping("/displayOne/{id}")
    public String showMyDetails(@PathVariable int id, Model model)
            {
            Item i = (Item) itemRepository.findOne((int) id);
            model.addAttribute("item", i);
            return "displayOne";
            }
}