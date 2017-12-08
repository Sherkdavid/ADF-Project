package sdh4.adf.grp2f.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

class Controller{
    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/")
    public String doWelcomeWithParams(Model model)
            {
            return "index";
            }

    @GetMapping("/usingParameter")
    public String doWelcomeWithParams(@RequestParam(value="name", defaultValue="To You!")String name, Model model)
            {
            String sentence = "Welcome " + name;
            model.addAttribute("message", sentence);
            return "Parameter";
            }
    @GetMapping("/displayAll")
    public String displayAll(Model model)
            {
            List<Item> p = itemRepository.findAll();
            model.addAttribute("people");
            return "displayAll";
            }

    @GetMapping("/displayOne/{id}")
    public String showMyDetails(@PathVariable int id, Model model)
            {
            Item i = (Item) itemRepository.findOne((int) id);
            model.addAttribute("person", id);
            return "displayOne";
            }
}