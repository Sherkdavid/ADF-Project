package repositories;

import entities.Customer;
import entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
/**
 * Exposes http://{ip}/order Rest interface
 */
@RepositoryRestResource(collectionResourceRel = "order", path="order")
public interface OrderRepository extends MongoRepository<Order, Integer> {
    //TODO figure out how Dbref refers to class variables to custom query correctly
    List<Order> findByCustomer(@Param("customer_id") int id);
}
