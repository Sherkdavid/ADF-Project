package repositories;

import entities.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Exposes http://{ip}/item Rest interface
 */
@RepositoryRestResource(collectionResourceRel = "item", path="item")
public interface ItemRepository extends MongoRepository<Item,Integer> {
}
