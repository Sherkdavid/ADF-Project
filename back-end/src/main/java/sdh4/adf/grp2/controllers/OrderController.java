package sdh4.adf.grp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdh4.adf.grp2.entities.Order;
import sdh4.adf.grp2.entities.OrderStatus;
import sdh4.adf.grp2.repositories.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/all")
    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    @GetMapping("/findByAddress/{address}")
    public List<Order> findByAddress(@PathVariable String address)
    {
        return orderRepository.findByCustomer_Address(address);
    }
    @GetMapping("/findByEmail/{email}")
    public List<Order> findByEmail(@PathVariable String email){
        return orderRepository.findByCustomer_Email(email);
    }

    @GetMapping("/findByStatus/{status}")
    public List<Order> findByStatus(@PathVariable String status)
    {
        return orderRepository.findByStatus(OrderStatus.valueOf(status));
    }

    @GetMapping("/deleteByStatus/{status}")
    public void deleteByStatus(@PathVariable String status)
    {
        orderRepository.deleteByStatus(OrderStatus.valueOf(status));
    }
    @GetMapping("/deleteByEmail/{email}")
    public void deleteByEmail(@PathVariable String email)
    {
        orderRepository.findByCustomer_Email(email);
    }
}
