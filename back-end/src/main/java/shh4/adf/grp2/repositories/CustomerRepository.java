package shh4.adf.grp2.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import shh4.adf.grp2.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Exposes http://{ip}/customer Rest interface
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findCustomerByName(@Param(value = "name") String name);
    Customer findCustomerByEmail(@Param(value = "email") String email);

}
