package sdh4.adf.grp2.repositories;

        import org.springframework.data.repository.query.Param;
        import sdh4.adf.grp2.entities.Item;
        import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Exposes http://{ip}/item Rest interface
 * */
//@RepositoryRestResource(collectionResourceRel = "items",path = "items")
public interface ItemRepository extends MongoRepository<Item,String> {
        Item findItemByName(@Param("name") String name);
        Item findItemByDescription(@Param("description") String description);
        void deleteByName(@Param("name") String name);
}
