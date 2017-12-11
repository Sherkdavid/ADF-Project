package sdh4.adf.grp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdh4.adf.grp2.entities.Customer;
import sdh4.adf.grp2.repositories.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;
    @RequestMapping("/all")
    public List<Customer> findAll(){ return customerRepository.findAll(); }

    @RequestMapping("/findByName/{name}")
    public Customer findByName(@PathVariable String name)
    {
        return customerRepository.findCustomerByName(name);
    }
    @RequestMapping("/findByEmail/{email}")
    public Customer findByEmail(@PathVariable String email)
    {
        return customerRepository.findCustomerByEmail(email);
    }
    @RequestMapping("/findByAddress/{address}")
    public Customer findByAddress(@PathVariable String address)
    {
        return customerRepository.findByAddress(address);
    }
    @RequestMapping("/findByPhone/{phone}")
    public Customer findByPhone(@PathVariable String phone)
    {
        return customerRepository.findByPhone(phone);
    }

    @RequestMapping("/deleteByEmail/{email}")
    public void deleteByEmail(@PathVariable String email)
    {
        customerRepository.deleteByEmail(email);
    }
}
