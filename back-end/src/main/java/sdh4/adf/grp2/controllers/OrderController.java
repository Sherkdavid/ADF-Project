package sdh4.adf.grp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdh4.adf.grp2.entities.Order;
import sdh4.adf.grp2.entities.OrderStatus;
import sdh4.adf.grp2.repositories.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    @GetMapping("/findByAddress/{address}")
    public List<Order> findByAddress(@PathVariable String address)
    {
        return orderRepository.findByCustomer_Address(address);
    }
    @RequestMapping(value = "/findByEmail/{email}", method = RequestMethod.GET)
    public List<Order> findByEmail(@PathVariable String email){
        return orderRepository.findByCustomer_Email(email);
    }

    @RequestMapping(value = "/findByStatus/{status}",method = RequestMethod.GET)
    public List<Order> findByStatus(@PathVariable String status)
    {
        return orderRepository.findByStatus(OrderStatus.valueOf(status));
    }

    @RequestMapping(value = "/deleteByStatus/{status}",method = RequestMethod.DELETE)
    public void deleteByStatus(@PathVariable String status)
    {
        orderRepository.deleteByStatus(OrderStatus.valueOf(status));
    }
    @RequestMapping(value = "/deleteByEmail/{email}",method = RequestMethod.DELETE)
    public void deleteByEmail(@PathVariable String email)
    {
        orderRepository.deleteByCustomer_Email(email);
    }
}
