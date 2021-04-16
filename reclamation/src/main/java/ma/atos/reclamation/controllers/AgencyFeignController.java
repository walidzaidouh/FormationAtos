package ma.atos.reclamation.controllers;

import ma.atos.reclamation.dto.AgencyDto;
import ma.atos.reclamation.proxies.AgencyServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgencyFeignController {


    @Autowired
    private AgencyServiceProxy agencyServiceProxy;

    @RequestMapping(value = "/agencies", method = RequestMethod.GET)
    public List<AgencyDto> getAgencies(){
        return agencyServiceProxy.getAgencies();
    }
}
