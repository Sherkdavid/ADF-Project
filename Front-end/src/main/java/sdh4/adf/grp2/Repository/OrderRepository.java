package sdh4.adf.grp2.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import shh4.adf.grp2.entities.Order;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Integer>
{
    List<Order> findByCustomer(@Param("customer_id") int id);
}

