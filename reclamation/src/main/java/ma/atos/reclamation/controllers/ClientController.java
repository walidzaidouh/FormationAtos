package ma.atos.reclamation.controllers;

import io.swagger.annotations.*;
import ma.atos.reclamation.converter.ClientConverter;
import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@Api(value = "Clients", tags ={"Clients"} )

public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConverter clientConverter;

    @ApiOperation(value = "Ajouter un client", notes = "", nickname = "AjouterClient")
    @ApiResponses(value = {

            @ApiResponse(code = 201, message = "Client added", response = ClientDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    @PostMapping
    public ClientDTO add(@ApiParam(value = "Client to added", required = true) @Valid @RequestBody ClientDTO clientDto) {

        return clientConverter.fromClientToClientDto(clientService.add(clientConverter.fromClientDtoToClient(clientDto)));

    }

    @ApiOperation(value = "Modify a customer by his ThirdPartyNumber", notes = "", nickname = "updateById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Client Modified", response = ClientDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    @PutMapping("/{thirdPartyNumber}")
    public ClientDTO updateById(@ApiParam(value = "Customer's third party number", required = true, defaultValue = "") @PathVariable long thirdPartyNumber,
                                @ApiParam(value = "Object with modification data", required = true) @Valid @RequestBody ClientDTO clientDTO) {

        return clientConverter.fromClientToClientDto(clientService.update(thirdPartyNumber, clientConverter.fromClientDtoToClient(clientDTO)));

    }

    @ApiOperation(value = "Delete a customer by his ThirdPartyNumber", notes = "", nickname = "deleteById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Client deleted", response = ClientDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    @DeleteMapping("/{thirdPartyNumber}")
    public void deleteById(@ApiParam(value = "Customer's third party number", required = true, defaultValue = "") @PathVariable long thirdPartyNumber) {
        clientService.deleteById(thirdPartyNumber);
    }

    @ApiOperation(value = "Return a customer by their ThirdPartyNumber", notes = "", nickname = "findById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Client found", response = ClientDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    @GetMapping("/{thirdPartyNumber}")
    public ClientDTO findById(@ApiParam(value = "Customer's third party number", required = true, defaultValue = "") @PathVariable Long thirdPartyNumber) {
        return clientConverter.fromClientToClientDto(clientService.findById(thirdPartyNumber).orElse(null));
    }

    @ApiOperation(value = "Return the client list", notes = "", nickname = "findAll")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "List of clients found", response = ClientDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    @GetMapping
    public List<ClientDTO> findAll() {
        return clientConverter.fromListClientsToListClientsDto(clientService.findAll());
    }


}
