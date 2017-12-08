package sdh4.adf.grp2.entities.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import sdh4.adf.grp2.entities.customer.Customer;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, Integer>
{
    @Query(value = "{ 'customerId' : ?0 }")
    List<Customer> findById(int customerId);
}
