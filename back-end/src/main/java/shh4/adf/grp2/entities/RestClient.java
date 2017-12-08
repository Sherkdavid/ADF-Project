package shh4.adf.grp2.entities;

import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import shh4.adf.grp2.entities.*;

public class RestClient
{
    RestTemplate restTemplate;
    String url;
    public RestClient(String url){
        this.url = url;
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    }

    public String getExtension(ApplicationRESTObject object)
    {
        if (object instanceof Customer)
            return "/customers";
        if(object instanceof Item)
            return "/items";
        if(object instanceof Order)
            return "/orders";
        return null;
    }

    public String insert(ApplicationRESTObject object)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ApplicationRESTObject> entity = new HttpEntity<>(object,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080"+getExtension(object), HttpMethod.POST, entity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

}
