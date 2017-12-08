package sdh4.adf.grp2.entities.item;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sdh4.adf.grp2.entities.item.Item;

@RepositoryRestResource(collectionResourceRel = "items",path = "items")
public interface ItemRepository extends MongoRepository<Item,Integer>
{

}
