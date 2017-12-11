package sdh4.adf.grp2.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import sdh4.adf.grp2.entities.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE,true);
        mapper.registerModule(new Jackson2HalModule());
        restTemplate = getRestTemplate();
    }

    private RestTemplate getRestTemplate() {
        RestTemplate template = new RestTemplate();

        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jackson2HalModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MappingJackson2HttpMessageConverter halConverter = new MappingJackson2HttpMessageConverter();
        halConverter.setObjectMapper(mapper);
        halConverter.setSupportedMediaTypes(Arrays.asList(MediaTypes.HAL_JSON));
        converters.add(halConverter);

        template.setMessageConverters(converters);

        return template;
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
        headers.setContentType(MediaTypes.HAL_JSON);
        return headers;
    }

    public ResponseEntity<String> insert(ApplicationJSONObject object) {
        HttpEntity<ApplicationJSONObject> entity = new HttpEntity<>(object, getJSONHeader());
        ResponseEntity<String> responseEntity = restTemplate.exchange(url + getExtension(object), HttpMethod.POST, entity, String.class);
        return responseEntity;
    }

    public List getCustomers() {
        return Arrays.stream(restTemplate.getForObject(url+"customers/all",Customer[].class)).collect(Collectors.toList());
    }

    public List<Order> getOrders() {
        return Arrays.stream(restTemplate.getForObject(url+"orders/all",Order[].class)).collect(Collectors.toList());
    }

    public List<Item> getItems() {

       return Arrays.stream(restTemplate.getForObject(url+"items/all",Item[].class)).collect(Collectors.toList());
    }

    public Customer findCustomerByName(String name) {
        return restTemplate.getForObject(url+"customers/findByName?name="+name,Customer.class);
    }
    public Customer findCustomerByEmail(String email) {
        return restTemplate.getForObject(url+"customers/findByEmail?email="+email,Customer.class);
    }
    public Customer findCustomerByPhone(String phone) {
        return restTemplate.getForObject(url+"customers/findByPhone?phone="+phone,Customer.class);
    }
    public Customer findCustomerByAddress(String address) {
        return restTemplate.getForObject(url+"customers/findByAddress?address="+address,Customer.class);
    }
    public boolean deleteCustomerByEmail(String email) {
        ResponseEntity<String> response = restTemplate.exchange(url+"/customers/search/deleteByEmail?email=" + email, HttpMethod.DELETE,null,String.class);

        return response.getStatusCode().is2xxSuccessful();
    }

    public List<Order> findOrderByCustomer_Email(String email) {
        return Arrays.stream(restTemplate.getForObject(url+"/orders/findByEmail?email="+email,Order[].class)).collect(Collectors.toList());
    }

    public List<Order> findOrderByCustomer_Address(String address){
        return Arrays.stream(restTemplate.getForObject(url+"orders/findByAddress?address="+address,Order[].class)).collect(Collectors.toList());
    }
    public List<Order> findOrderByStatus(OrderStatus status){
        return Arrays.stream(restTemplate.getForObject(url+"orders/findByStatus?status="+ status,Order[].class)).collect(Collectors.toList());
    }
    public boolean deleteOrderByEmail(String email){
        ResponseEntity<String> response = restTemplate.exchange(url+"/orders/deleteByEmail?email=" + email, HttpMethod.DELETE,null,String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
    public boolean deleteOrderByStatus(OrderStatus status){
        ResponseEntity<String> response = restTemplate.exchange(url+"/orders/deleteByStatus?status=" + status, HttpMethod.DELETE,null,String.class);
        return response.getStatusCode().is2xxSuccessful();
    }

    public Item findItemByName(String name)
    {
        return restTemplate.getForObject(url+"items/findByName?name="+name,Item.class);
    }

    public Item findItemByDescription(String description)
    {
        return restTemplate.getForObject(url+"items/findByDescription?description="+description,Item.class);
    }
    public boolean deleteItemByName(String name)
    {
        ResponseEntity<String> response = restTemplate.exchange(url+"/orders/deleteByName?name=" + name, HttpMethod.DELETE,null,String.class);
        return response.getStatusCode().is2xxSuccessful();
    }


}