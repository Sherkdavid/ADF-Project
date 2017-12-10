package sdh4.adf.grp2.repositories;

import org.springframework.data.repository.query.Param;
import sdh4.adf.grp2.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Exposes http://{ip}/customer Rest interface
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findCustomerByName(@Param(value = "name") String name);
    Customer findCustomerByEmail(@Param(value = "email") String email);
    Customer findByAddress(@Param(value = "address") String address);
    Customer findByPhone(@Param(value = "phone") String phone);
    void deleteByEmail(@Param(value = "email")String email);
}
