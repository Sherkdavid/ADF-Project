package shh4.adf.grp2.repositories;

        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import shh4.adf.grp2.entities.Item;
        import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Exposes http://{ip}/item Rest interface
 * */
@RepositoryRestResource(collectionResourceRel = "items",path = "items")
public interface ItemRepository extends MongoRepository<Item,Integer> {
}
