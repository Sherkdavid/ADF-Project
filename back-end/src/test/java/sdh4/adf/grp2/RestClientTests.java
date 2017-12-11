package sdh4.adf.grp2;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.ResponseEntity;
import sdh4.adf.grp2.entities.*;
import sdh4.adf.grp2.rest.RestClient;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RestClientTest
public class RestClientTests {
	/**
	 * Requires back end to be running as an endpoint on localhost
	 */

	@Test /** POST **/
	public void test01() {
		RestClient api = new RestClient("http://localhost:8080");
		Customer customer = new Customer("David","dmurphy10@mycit.ie","0892052849","Sherkin Island");
		ResponseEntity<String> response  = api.insert(customer);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		Item daffodil = new Item("Daffodil","Yellow flower",0.8);
		Item hyacinth = new Item("Hyacinth","Sounds like a pokemon",1.0);
		response = api.insert(daffodil);
		assertTrue(response.getStatusCode().is2xxSuccessful());

		response = api.insert(hyacinth);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		Order order = new Order(customer, OrderStatus.RECEIVED);

		order.getOrderLines().add(new OrderLine(daffodil,10));
		order.getOrderLines().add(new OrderLine(hyacinth,10));
		response = api.insert(order);
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}
	@Test /** GETS **/
	public void test02() throws IOException {
		RestClient api = new RestClient("http://localhost:8080");
		List<Item> items = api.getItems();
		for(Item i: items)
			System.out.println(i.getName());
		assertFalse(items.isEmpty());
		List list = null;
		list = api.getOrders();
		assertFalse(list.isEmpty());
		list = api.getCustomers();
		assertFalse(list.isEmpty());
		System.out.println(api.findOrderByCustomer_Email("dmurphy10@mycit.ie").get(0).getStatus());
	}

}
