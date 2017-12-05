package sdh4.adf.grp2.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import shh4.adf.grp2.entities.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
