package shh4.adf.grp2.repositories;

        import shh4.adf.grp2.entities.Item;
        import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Exposes http://{ip}/item Rest interface
 */
public interface ItemRepository extends MongoRepository<Item,Integer> {
}
