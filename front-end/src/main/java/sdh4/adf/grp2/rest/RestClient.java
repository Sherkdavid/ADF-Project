package sdh4.adf.grp2.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sdh4.adf.grp2.entities.ApplicationJSONObject;
import sdh4.adf.grp2.entities.Customer;
import sdh4.adf.grp2.entities.Item;
import sdh4.adf.grp2.entities.Order;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Endpoint for client interfacing with REST API
 */
public class RestClient {
    @Autowired
    RestTemplate restTemplate;
    String url;
    ObjectMapper mapper;

    public RestClient(String url) {
        this.url = url;
        mapper = new ObjectMapper();
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    }

    public String getExtension(ApplicationJSONObject object) {
        if (object instanceof Customer)
            return "/customers";
        if (object instanceof Item)
            return "/items";
        if (object instanceof Order)
            return "/orders";
        return null;
    }

    public HttpHeaders getJSONHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/x-spring-data-verbose+json"));
        return headers;
    }

    public ResponseEntity<String> insert(ApplicationJSONObject object) {
        HttpEntity<ApplicationJSONObject> entity = new HttpEntity<>(object, getJSONHeader());
        ResponseEntity<String> responseEntity = restTemplate.exchange(url + getExtension(object), HttpMethod.POST, entity, String.class);
        return responseEntity;
    }
    public List getCustomers() throws IOException {
        ResponseEntity<String> response = restTemplate.exchange(url + "/customers", HttpMethod.GET, null, String.class);
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode node = root.path("customers");
        System.err.println(node.asText());
        return mapper.readValue(node.asText(),new TypeReference<List<Order>>(){});
    }

    public List getOrders() throws IOException {
        ResponseEntity<String> response = restTemplate.exchange(url + "/orders", HttpMethod.GET, null, String.class);
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode node = root.path("orders");
        System.err.println(node.asText());
        return mapper.readValue(node.asText(),new TypeReference<List<Order>>(){});
    }

    public List getItems() throws IOException {
        ResponseEntity<String> response = restTemplate.exchange(url + "/items", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        });
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode node = root.path("items");
        System.err.println(node.asText());
        return mapper.readValue(node.asText(),new TypeReference<List<Item>>(){});
    }

    public Customer findCustomerByName(String name) throws IOException {
        ResponseEntity<String> response = restTemplate.exchange(url+"/customers/search/findByName?name=" + name, HttpMethod.GET,null,String.class);

        return mapper.readValue(response.getBody().toString(),Customer.class);
    }
    public Customer findCustomerByEmail(String email) throws IOException {
        ResponseEntity<String> response = restTemplate.exchange(url+"/customers/search/findByName?email=" + email, HttpMethod.GET,null,String.class);

        return mapper.readValue(response.getBody().toString(),Customer.class);
    }
    public Customer findCustomerByPhone(String phone) throws IOException {
        ResponseEntity<String> response = restTemplate.exchange(url+"/customers/search/findByName?phone=" + phone, HttpMethod.GET,null,String.class);
        return mapper.readValue(response.getBody().toString(),Customer.class);
    }
    public Customer findCustomerByAddress(String address) throws IOException {
        ResponseEntity<Customer> response = restTemplate.exchange(url+"/customers/search/findByName?address=" + address, HttpMethod.GET,null,Customer.class);

        return mapper.readValue(response.getBody().toString(),Customer.class);
    }
    public boolean deleteCustomerByEmail(String email) throws IOException {
        ResponseEntity<String> response = restTemplate.exchange(url+"/customers/search/deleteByEmail?email=" + email, HttpMethod.DELETE,null,String.class);

        return response.getStatusCode().is2xxSuccessful();
    }

    public List<Order> findOrdersByCustomer_Email(String email) throws IOException {
        ResponseEntity<String> response = restTemplate.exchange(url+"/orders/search/findByCustomer_Email?email=" + email, HttpMethod.GET,null,String.class);
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode node = root.path("orders");
        System.err.println(node.asText());
        return mapper.readValue(node.asText(),new TypeReference<List<Order>>(){});    }
}