package sdh4.adf.grp2.entities.order;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import sdh4.adf.grp2.entities.order.Order;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Integer>
{
    List<Order> findByCustomer(@Param("customer_id") int id);
}

