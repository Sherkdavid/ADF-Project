package shh4.adf.grp2;

import shh4.adf.grp2.entities.Customer;
import shh4.adf.grp2.entities.RestClient;

/**
 * Working template for data input via RestTemplate
 */
public class DataInput {

    public static void main(String[] args)
    {
        RestClient api = new RestClient("http://localhost:8080");
        String result = api.insert(new Customer("David","dmurphy10@mycit.ie","0892052849","Sherkin Island"));
        System.out.println(result);
    }
}
