package shh4.adf.grp2;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import shh4.adf.grp2.entities.Item;

/**
 * Working template for data input via RestTemplate
 */
public class DataInput {

    public static void main(String[] args)
    {
        RestTemplate restTemplate = new RestTemplate();
       // restTemplate.postForEntity("")
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Item> entity = new HttpEntity<Item>(new Item("Daffodil","Test"),headers);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        // Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/items", HttpMethod.POST, entity, String.class);
        String result = responseEntity.getBody();
        System.out.println(result);
    }
}
