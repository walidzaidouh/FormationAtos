package ma.atos.reclamation.controllers;

import ma.atos.reclamation.dto.AgencyDto;
import ma.atos.reclamation.proxies.AgencyServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgencyFeignController {

    @Autowired
    private AgencyServiceProxy agencyServiceProxy;

    @RequestMapping(value = "/agencies", method = RequestMethod.GET)
    public List<AgencyDto> getAgencies(){
        return agencyServiceProxy.getAgencies();
    }

    @GetMapping("/agencies/{code}")
    AgencyDto getAgencyById(@PathVariable("code") String code){

        return agencyServiceProxy.getAgencyByCode(code);
    }
}
