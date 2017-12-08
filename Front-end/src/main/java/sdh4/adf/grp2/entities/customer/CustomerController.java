package sdh4.adf.grp2.entities.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable("id") int id) {

        Customer c = CustomerService.findById(id);

        model.addAttribute("customer", c);

        return "customer/view";
    }

    @GetMapping("/create")
    public String createForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer/create";

    }

    @PostMapping("/")
    public String createSubmit(@Valid Customer customer, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "customer/create";
        }

        CustomerService.save(customer);

        model.addAttribute("customer", customer);

        return "redirect:/customer/";

    }
}
