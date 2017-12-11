package sdh4.adf.grp2.repositories;

        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import sdh4.adf.grp2.entities.Order;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.data.repository.query.Param;
        import sdh4.adf.grp2.entities.OrderStatus;

        import java.util.List;
/**
 * Exposes http://{ip}/order Rest interface
 */
@RepositoryRestResource(collectionResourceRel = "orders", path="orders")
public interface OrderRepository extends MongoRepository<Order, String> {
        List<Order> findByCustomer_Email(@Param("email") String email);
        List<Order> findByStatus(@Param("status") OrderStatus status);
        List<Order> findByCustomer_Address(@Param("address") String address);
        void deleteByStatus(@Param("status")OrderStatus status);
        void deleteByCustomer_Email(@Param("email") String email);
}
