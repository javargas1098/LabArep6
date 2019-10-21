package springboot.security.controller;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@RestController
@RequestMapping(value="/math")
public class MathController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Environment env;


    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String getData() {
        System.out.println("Returning data from client own data method");
        return "Hello from client data method";
    }

    @RequestMapping(value = "/data/server/sum", method = RequestMethod.GET)
    public String getServerDataSum() {
        System.out.println("Got inside server data method");
        try {
            String Endpoint = env.getProperty("endpoint.serverData");
            System.out.println("MS Endpoint name : [" + Endpoint + "]");

            return restTemplate.getForObject(new URI(Endpoint+"/sum/5/7"), String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Exception occurred.. so, returning default data";
    }
    @RequestMapping(value = "/data/server/res", method = RequestMethod.GET)
    public String getServerDataRes() {
        System.out.println("Got inside server data method");
        try {
            String Endpoint = env.getProperty("endpoint.serverData");
            System.out.println("MS Endpoint name : [" + Endpoint + "]");

            return restTemplate.getForObject(new URI(Endpoint+"/res/12/9"), String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Exception occurred.. so, returning default data";
    }
    @RequestMapping(value = "/data/server/mul", method = RequestMethod.GET)
    public String getServerDataMul() {
        System.out.println("Got inside server data method");
        try {
            String Endpoint = env.getProperty("endpoint.serverData");
            System.out.println("MS Endpoint name : [" + Endpoint + "]");

            return restTemplate.getForObject(new URI(Endpoint+"/mul/2/2"), String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Exception occurred.. so, returning default data";
    }
    @RequestMapping(value = "/data/server/div", method = RequestMethod.GET)
    public String getServerDataDiv() {
        System.out.println("Got inside server data method");
        try {
            String Endpoint = env.getProperty("endpoint.serverData");
            System.out.println("MS Endpoint name : [" + Endpoint + "]");

            return restTemplate.getForObject(new URI(Endpoint+"/div/1/2"), String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Exception occurred.. so, returning default data";
    }
}
