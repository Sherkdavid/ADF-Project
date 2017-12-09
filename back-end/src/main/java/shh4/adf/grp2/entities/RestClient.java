package shh4.adf.grp2.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * Endpoint for client interfacing with REST API
 */
public class RestClient {
    RestTemplate restTemplate;
    String url;

    public RestClient(String url) {
        this.url = url;
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    }

    public String getExtension(ApplicationRESTObject object) {
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
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public ResponseEntity<String> insert(ApplicationRESTObject object) {
        HttpEntity<ApplicationRESTObject> entity = new HttpEntity<>(object, getJSONHeader());
        ResponseEntity<String> responseEntity = restTemplate.exchange(url + getExtension(object), HttpMethod.POST, entity, String.class);
        return responseEntity;
    }

    public List getCustomers() {
        ResponseEntity<HashMap> response = restTemplate.exchange(url + getExtension(new Customer()), HttpMethod.GET, null, HashMap.class);
        return (List) ((HashMap) response.getBody().get("_embedded")).get("customers");
    }

    public List getOrders() {
        ResponseEntity<HashMap> response = restTemplate.exchange(url + getExtension(new Order()), HttpMethod.GET, null, HashMap.class);
        return (List) ((HashMap) response.getBody().get("_embedded")).get("orders");
    }

    public List getItems() {
        ResponseEntity<HashMap> response = restTemplate.exchange(url + getExtension(new Item()), HttpMethod.GET, null, HashMap.class);
        return (List) ((HashMap) response.getBody().get("_embedded")).get("items");
    }
}
