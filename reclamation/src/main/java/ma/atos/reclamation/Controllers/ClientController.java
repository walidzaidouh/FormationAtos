package ma.atos.reclamation.Controllers;

import ma.atos.reclamation.Models.Client;
import ma.atos.reclamation.Services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")

public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping
    public Client add(@RequestBody Client client) {
        return clientService.add(client);

    }

    @PutMapping("/{thirdPartyNumber}")
    public Client update(@PathVariable long thirdPartyNumber, @RequestBody Client client) {

        return clientService.update(thirdPartyNumber, client);

    }

    @DeleteMapping("/{thirdPartyNumber}")
    public void deleteById(@PathVariable long thirdPartyNumber) {
        clientService.deleteById(thirdPartyNumber);
    }

    @GetMapping("/{thirdPartyNumber}")
    public Optional<Client> findById(@PathVariable Long thirdPartyNumber) {
        return clientService.findById(thirdPartyNumber);
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }


}
