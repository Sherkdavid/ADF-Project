package sdh4.adf.grp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sdh4.adf.grp2.entities.Customer;
import sdh4.adf.grp2.repositories.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Customer> findAll(){ return customerRepository.findAll(); }

    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET )
    public Customer findByName(@PathVariable String name)
    {
        return customerRepository.findCustomerByName(name);
    }
    @RequestMapping(value = "/findByEmail/{email}", method = RequestMethod.GET)
    public Customer findByEmail(@PathVariable String email)
    {
        return customerRepository.findCustomerByEmail(email);
    }
    @RequestMapping(value = "/findByAddress/{address}", method = RequestMethod.GET)
    public Customer findByAddress(@PathVariable String address)
    {
        return customerRepository.findByAddress(address);
    }
    @RequestMapping(value = "/findByPhone/{phone}", method = RequestMethod.GET)
    public Customer findByPhone(@PathVariable String phone)
    {
        return customerRepository.findByPhone(phone);
    }

    @RequestMapping(value = "/deleteByEmail/{email}", method = RequestMethod.DELETE)
    public void deleteByEmail(@PathVariable String email)
    {
        customerRepository.deleteByEmail(email);
    }
}
