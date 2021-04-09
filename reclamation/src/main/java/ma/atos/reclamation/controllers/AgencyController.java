package ma.atos.reclamation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/agencies")
public class AgencyController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/")
    public ResponseEntity<String> callAgencyListThroughReclamation() throws Exception{

        RestTemplate restTemplate = new RestTemplate();
        try{
            return new ResponseEntity( restTemplate.getForObject(getBaseUrl()+"/agencies",String.class), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity( restTemplate.getForObject(getBaseUrl()+"/agencies",String.class), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/load-balancing")
    String loadBalancing() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("AGENCYMANAGMENT");
        return serviceInstance.getUri().toString();
    }
    private String getBaseUrl(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("AGENCYMANAGMENT");
        return serviceInstance.getUri().toString();
    }
}
