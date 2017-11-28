package shh4.adf.grp2.repositories;

import shh4.adf.grp2.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Exposes http://{ip}/customer Rest interface
 */
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
