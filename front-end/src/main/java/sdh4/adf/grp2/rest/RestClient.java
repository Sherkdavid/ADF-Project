package sdh4.adf.grp2.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import sdh4.adf.grp2.entities.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Endpoint for client interfacing with REST API
 */
public class RestClient {
    @Autowired
    RestTemplate restTemplate;
    String url;

    public RestClient(String url) {
        this.url = url;
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
        return restTemplate.getForObject(url+"customers/findByName/{name}/",Customer.class,name);
    }
    public Customer findCustomerByEmail(String email) {
        return restTemplate.getForObject(url+"customers/findByEmail/{email}/",Customer.class,email);
    }
    public Customer findCustomerByPhone(String phone) {
        return restTemplate.getForObject(url+"customers/findByPhone?{phone}/",Customer.class,phone);
    }
    public Customer findCustomerByAddress(String address) {
        return restTemplate.getForObject(url+"customers/findByAddress{address}/",Customer.class,address);
    }
    public void deleteCustomerByEmail(String email) {
        restTemplate.delete(url+"customers/deleteByEmail/{email}/",email);
    }

    public List<Order> findOrderByCustomer_Email(String email) {
        return Arrays.stream(restTemplate.getForObject(url+"orders/findByEmail/{email}/",Order[].class,email)).collect(Collectors.toList());
    }

    public List<Order> findOrderByCustomer_Address(String address){
        return Arrays.stream(restTemplate.getForObject(url+"orders/findByAddress/{address}/",Order[].class,address)).collect(Collectors.toList());
    }
    public List<Order> findOrderByStatus(OrderStatus status){
        return Arrays.stream(restTemplate.getForObject(url+"orders/findByStatus/{status}/",Order[].class,status)).collect(Collectors.toList());
    }
    public void deleteOrderByEmail(String email){
        restTemplate.delete(url+"orders/deleteByEmail/{email}/",email);
    }
    public void deleteOrderByStatus(OrderStatus status){
        restTemplate.delete(url+"orders/deleteByStatus/{status}/",status);
    }

    public Item findItemByName(String name)
    {
        return restTemplate.getForObject(url+"items/findByName/{name}/",Item.class,name);
    }

    public Item findItemByDescription(String description)
    {
        return restTemplate.getForObject(url+"items/findByDescription/{description}/",Item.class,description);
    }
    public void deleteItemByName(String name)
    {
        restTemplate.delete(url+"items/deleteByName/{name}/", name);
    }


}