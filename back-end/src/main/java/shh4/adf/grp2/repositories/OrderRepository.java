package shh4.adf.grp2.repositories;

        import shh4.adf.grp2.entities.Order;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.data.repository.query.Param;

        import java.util.List;
/**
 * Exposes http://{ip}/order Rest interface
 */
public interface OrderRepository extends MongoRepository<Order, String> {
        List<Order> findAllByCustomer_Email(@Param("email") String id);
}
