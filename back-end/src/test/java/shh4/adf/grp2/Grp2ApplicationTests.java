package shh4.adf.grp2;

import com.mongodb.DBRef;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import shh4.adf.grp2.entities.*;

import java.util.List;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Grp2ApplicationTests {
	/**
	 * TODO Test units for MongoRepository Methods
	 */
	@Test /** GETS **/
	public void test02()
	{
		RestClient api = new RestClient("http://localhost:8080");
		List list = api.getItems();
		assertFalse(list.isEmpty());
		System.out.println(list);
		list = api.getOrders();
		assertFalse(list.isEmpty());
		System.out.println(list);
		list = api.getCustomers();
		assertFalse(list.isEmpty());
		System.out.println(list);
	}

	@Test /** POST **/
	public void test01() {
		RestClient api = new RestClient("http://localhost:8080");
		Customer customer = new Customer("David","dmurphy10@mycit.ie","0892052849","Sherkin Island");
		ResponseEntity<String> response  = api.insert(customer);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		Item daffodil = new Item("Daffodil","Yellow flower");
		Item hyacinth = new Item("Hyacinth","Sounds like a pokemon");
		response = api.insert(daffodil);
		assertTrue(response.getStatusCode().is2xxSuccessful());

		response = api.insert(hyacinth);
		assertTrue(response.getStatusCode().is2xxSuccessful());

		Order order = new Order(customer,"Received");

		order.getOrderLines().add(new OrderLine(daffodil,10));
		order.getOrderLines().add(new OrderLine(hyacinth,10));
		response = api.insert(order);
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}

}
