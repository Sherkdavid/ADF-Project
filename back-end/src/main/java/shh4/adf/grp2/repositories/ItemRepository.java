package shh4.adf.grp2.repositories;

        import org.springframework.data.mongodb.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import org.springframework.data.rest.core.annotation.RestResource;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import shh4.adf.grp2.entities.Item;
        import org.springframework.data.mongodb.repository.MongoRepository;

        import java.util.List;

/**
 * Exposes http://{ip}/item Rest interface
 * */
//@RepositoryRestResource(collectionResourceRel = "items",path = "items")
public interface ItemRepository extends MongoRepository<Item,String> {
        List<Item> findAllByName(@Param("name") String name);
}
