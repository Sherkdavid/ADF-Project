package sdh4.adf.grp2.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shh4.adf.grp2.entities.Item;

@RepositoryRestResource(collectionResourceRel = "items",path = "items")
public interface ItemRepository extends MongoRepository<Item,Integer>
{

}
