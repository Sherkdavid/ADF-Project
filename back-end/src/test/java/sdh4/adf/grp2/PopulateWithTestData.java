package sdh4.adf.grp2;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import sdh4.adf.grp2.entities.*;
import sdh4.adf.grp2.rest.RestClient;

import static org.junit.Assert.assertTrue;

public class PopulateWithTestData {

    @Test
    public void insert()
    {
        RestClient api = new RestClient("http://localhost:8080");
        Customer customer = new Customer("David","dmurphy10@mycit.ie","0892052849","Sherkin Island");
        ResponseEntity<String> response  = api.insert(customer);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        Item daffodil = new Item("Daffodil","Yellow flower",0.8);
        Item hyacinth = new Item("Hyacinth","Sounds like a pokemon",1.0);
        Item tulip = new Item("Tulip","Sounds like a pokemon",1.2);
        response = api.insert(daffodil);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        response = api.insert(hyacinth);
        api.insert(tulip);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        Order order = new Order(customer, OrderStatus.RECEIVED);
        order.getOrderLines().add(new OrderLine(daffodil,10));
        order.getOrderLines().add(new OrderLine(hyacinth,10));
        response = api.insert(order);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}
