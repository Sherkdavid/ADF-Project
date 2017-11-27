package repositories;

import entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Exposes http://{ip}/customer Rest interface
 */
@RepositoryRestResource(collectionResourceRel = "customer", path="customer")
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
