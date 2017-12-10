package sdh4.adf.grp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sdh4.adf.grp2.entities.Item;
import sdh4.adf.grp2.rest.RestClient;

import java.io.IOException;
import java.util.List;

@Controller
public class WebController {
    RestClient rest = new RestClient("http://localhost:8080");
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public void createOrder(Model model) throws IOException {

        List<Item> items = rest.getItems();
        model.addAttribute("items",items);

    }

}
