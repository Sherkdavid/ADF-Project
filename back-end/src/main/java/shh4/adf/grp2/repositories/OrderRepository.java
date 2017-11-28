package shh4.adf.grp2.repositories;

import shh4.adf.grp2.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * Exposes http://{ip}/order Rest interface
 */
public interface OrderRepository extends MongoRepository<Order, Integer> {
    //TODO figure out how Dbref refers to class variables to custom query correctly
    List<Order> findByCustomer(@Param("customer_id") int id);
}
