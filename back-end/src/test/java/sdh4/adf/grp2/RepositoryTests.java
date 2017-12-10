package sdh4.adf.grp2;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sdh4.adf.grp2.entities.*;
import sdh4.adf.grp2.repositories.CustomerRepository;
import sdh4.adf.grp2.repositories.ItemRepository;
import sdh4.adf.grp2.repositories.OrderRepository;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTests {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Test
    /** Mongo Repositories **/
    public void test01() //Test insert and retrieval of item
    {
        itemRepository.save(new Item("Rose","Fierce romantic flower altogether this one"));
        assertTrue(itemRepository.findItemByName("Rose").getDescription().equals("Fierce romantic flower altogether this one"));
        assertTrue(itemRepository.findItemByDescription("Fierce romantic flower altogether this one").getName().equals("Rose"));
    }

    @Test //Test insert and retrieval of customer
    public void test02()
    {
        customerRepository.save(new Customer("David Murphy","dmurphy10@mycit.ie","0892052849","Sherkin Island"));
        assertTrue(customerRepository.findCustomerByEmail("dmurphy10@mycit.ie").getName().equals("David Murphy"));
        assertTrue(customerRepository.findCustomerByName("David Murphy").getEmail().equals("dmurphy10@mycit.ie"));
        assertTrue(customerRepository.findByPhone("0892052849").getName().equals("David Murphy"));
        assertTrue(customerRepository.findByAddress("Sherkin Island").getName().equals("David Murphy"));
    }

    @Test //Test insert and retrieval of order
    public void test03()
    {
        Item daffodil = new Item("Daffodil","Yellow flower");
        Item hyacinth = new Item("Hyacinth","Sounds like a pokemon");
        Customer customer = new Customer("David","dmurphy10@mycit.ie","0892052849","Sherkin Island");
        Order order = new Order(customer, OrderStatus.RECEIVED);
        order.getOrderLines().add(new OrderLine(daffodil,10));
        order.getOrderLines().add(new OrderLine(hyacinth,10));
        List<Order> list = orderRepository.findByStatus(OrderStatus.RECEIVED);
        orderRepository.save(order);
        assertFalse(list.isEmpty());
        for(Order o: list)
            assertTrue(o.getCustomer().getName().equals("David"));
        assertFalse(list.isEmpty());
        for(Order o: list)
            assertTrue(o.getCustomer().getName().equals("David"));
        list = orderRepository.findByCustomer_Address("Sherkin Island");
        assertFalse(list.isEmpty());
        for(Order o: list)
            assertTrue(o.getCustomer().getName().equals("David"));
    }
    @Test //Test delete item
    public void test04()
    {
        itemRepository.deleteByName("Daffodil");
        itemRepository.deleteByName("Hyacinth");
        itemRepository.deleteByName("Rose");
        assertTrue(itemRepository.findAll().isEmpty());
    }
    @Test //test delete customer
    public void test05()
    {
        customerRepository.deleteByEmail("dmurphy10@mycit.ie");
        assertTrue(customerRepository.findAll().isEmpty());
    }
    @Test
    public void test06()
    {
        Order order = orderRepository.findByCustomer_Address("Sherkin Island").get(0);
        orderRepository.deleteByCustomer_Email("dmurphy10@mycit.ie");
        assertTrue(orderRepository.findAll().isEmpty());
        order.setStatus(OrderStatus.DELIVERED);
        orderRepository.insert(order);
        orderRepository.deleteByStatus(OrderStatus.DELIVERED);
        assertTrue(orderRepository.findAll().isEmpty());
    }
}
