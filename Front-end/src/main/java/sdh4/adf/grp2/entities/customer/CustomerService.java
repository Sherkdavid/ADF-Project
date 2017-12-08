package sdh4.adf.grp2.entities.customer;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService
{

    @Autowired
    private static CustomerRepository customerRepository;

    public static Customer findById(int id) {
        return customerRepository.findOne(id);
    }

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    public static void save(Customer customer) {
        customerRepository.save(customer);
    }
}
