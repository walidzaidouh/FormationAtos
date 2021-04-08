package ma.atos.reclamation.controllers;

import ma.atos.reclamation.converter.ClientConverter;
import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.models.Client;
import ma.atos.reclamation.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")

public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConverter clientConverter;

    @PostMapping
    public ClientDTO add(@RequestBody ClientDTO clientDto) {

        return clientConverter.FromClientToClientDto(clientService.add(clientConverter.FromClientDtoToClient(clientDto)));

    }

    @PutMapping("/{thirdPartyNumber}")
    public ClientDTO update(@PathVariable long thirdPartyNumber, @RequestBody ClientDTO clientDTO) {

        return clientConverter.FromClientToClientDto(clientService.update(thirdPartyNumber, clientConverter.FromClientDtoToClient(clientDTO)));

    }

    @DeleteMapping("/{thirdPartyNumber}")
    public void deleteById(@PathVariable long thirdPartyNumber) {
        clientService.deleteById(thirdPartyNumber);
    }

    @GetMapping("/{thirdPartyNumber}")
    public ClientDTO findById(@PathVariable Long thirdPartyNumber) {
        return clientConverter.FromClientToClientDto(clientService.findById(thirdPartyNumber).get());
    }

    @GetMapping
    public List<ClientDTO> findAll() {
        return clientConverter.FromListClientsToListClientsDto(clientService.findAll());
    }


}
