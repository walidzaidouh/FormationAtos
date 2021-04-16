package ma.atos.reclamation.proxies;

import ma.atos.reclamation.dto.AgencyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "AGENCY-API")
public interface AgencyServiceProxy {

    @RequestMapping(value = "/agencies", method = RequestMethod.GET)
    List<AgencyDto> getAgencies();
}
