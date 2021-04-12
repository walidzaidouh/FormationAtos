package ma.atos.reclamation.controllers;

import io.swagger.annotations.*;
import ma.atos.reclamation.converter.ClientConverter;
import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.models.Client;
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

            @ApiResponse(code = 201, message = "Client ajouté", response = ClientDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    @PostMapping
    public ClientDTO add(@ApiParam(value = "Client à ajouter", required = true) @Valid @RequestBody ClientDTO clientDto) {

        return clientConverter.FromClientToClientDto(clientService.add(clientConverter.FromClientDtoToClient(clientDto)));

    }

    @ApiOperation(value = "Modifier un client par son ThirdPartyNumber", notes = "", nickname = "updateById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Client Modifié", response = ClientDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    @PutMapping("/{thirdPartyNumber}")
    public ClientDTO updateById(@ApiParam(value = "Numéro de tiers du client", required = true, defaultValue = "") @PathVariable long thirdPartyNumber,
                                @ApiParam(value = "Objet avec les données de modifications", required = true) @Valid @RequestBody ClientDTO clientDTO) {

        return clientConverter.FromClientToClientDto(clientService.update(thirdPartyNumber, clientConverter.FromClientDtoToClient(clientDTO)));

    }

    @ApiOperation(value = "Supprimer un client par son ThirdPartyNumber", notes = "", nickname = "deleteById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Client supprimé", response = ClientDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    @DeleteMapping("/{thirdPartyNumber}")
    public void deleteById(@ApiParam(value = "Numéro de tiers du client", required = true, defaultValue = "") @PathVariable long thirdPartyNumber) {
        clientService.deleteById(thirdPartyNumber);
    }

    @ApiOperation(value = "Retourner un client par son ThirdPartyNumber", notes = "", nickname = "findById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Client trouvé", response = ClientDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    @GetMapping("/{thirdPartyNumber}")
    public ClientDTO findById(@ApiParam(value = "Numéro de tiers du client", required = true, defaultValue = "") @PathVariable Long thirdPartyNumber) {
        return clientConverter.FromClientToClientDto(clientService.findById(thirdPartyNumber).get());
    }

    @ApiOperation(value = "Retourner la liste des clients", notes = "", nickname = "findAll")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Liste des clients trouvées", response = ClientDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    @GetMapping
    public List<ClientDTO> findAll() {
        return clientConverter.FromListClientsToListClientsDto(clientService.findAll());
    }


}
