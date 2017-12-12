package sdh4.adf.grp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sdh4.adf.grp2.entities.*;
import sdh4.adf.grp2.rest.RestClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    RestClient rest = new RestClient("http://localhost:8080");
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String createOrder(Model model) throws IOException {
        Order order = new Order();
        order.setCustomer(new Customer());
        List<Item> items = rest.getItems();
        for(Item item:items)
            order.getOrderLines().add(new OrderLine(item,0));
        model.addAttribute("order",order);
        return "order";
    }


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String sendOrder(@ModelAttribute Order order)
    {
        order.setStatus(OrderStatus.RECEIVED);
        rest.insert(order);
        return "result";
    }
    @RequestMapping(value = "/dashboard", method=RequestMethod.GET)
    public String getOrderCount(Model model)
    {
        List<Order> orders = rest.getOrders();
        model.addAttribute("total_orders",orders.size());
        return "dashboard";
    }
}
