package ma.atos.reclamation.controllers;

import io.swagger.annotations.*;
import ma.atos.reclamation.converter.ReclamationConverter;
import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.dto.ReclamationDTO;
import ma.atos.reclamation.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reclamations")
@Api(value = "Reclamations", tags ={"Reclamations"})
public class ReclamationController {
    @Autowired
    ReclamationService reclamationService;

    @Autowired
    ReclamationConverter reclamationConverter;

    @ApiOperation(value = "Ajouter une réclamation", notes = "", nickname = "AjouterReclamation")
    @ApiResponses(value = {

            @ApiResponse(code = 201, message = "Reclamation ajouté", response = ReclamationDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })
    // add reclamation method
    @PostMapping
    public ReclamationDTO add(@ApiParam(value = "Réclamation à ajouter", required = true)@Valid @RequestBody ReclamationDTO reclamationDTO) {
        return reclamationConverter.reclamationToReclamationDto(reclamationService.add(reclamationConverter.reclamationDtoToReclamation(reclamationDTO)));
    }

    @ApiOperation(value = "Modifier une modification par sa  reference;", notes = "", nickname = "updateByReference")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Réclamation Modifié", response = ReclamationDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })
    // Update reclamation method
    @PutMapping("/{reference}")
    public ReclamationDTO update(@ApiParam(value = "Reference de la réclamation", required = true, defaultValue = "")
                                     @PathVariable String reference,
                                 @ApiParam(value = "Reference de la réclamation", required = true, defaultValue = "")
                                 @Valid @RequestBody ReclamationDTO reclamationDTO) {
        return reclamationConverter.reclamationToReclamationDto(reclamationService.update(reference, reclamationConverter.reclamationDtoToReclamation(reclamationDTO)));
    }

    @ApiOperation(value = "Supprimer une réclamation par sa reference", notes = "", nickname = "deleteByReference")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Réclamation supprimé", response = ReclamationDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })
    // delete reclamation method
    @DeleteMapping("/{reference}")
    public void deleteById(@ApiParam(value = "Reference de la réclamation", required = true, defaultValue = "")
                               @PathVariable String reference) {

        reclamationService.deleteById(reference);
    }

    @ApiOperation(value = "Retourner un client par sa reference", notes = "", nickname = "findByReference")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Réclamation trouvé", response = ReclamationDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    // Get a single reclamation by id
    @GetMapping("/{reference}")
    public ReclamationDTO findById(@ApiParam(value = "Reference de la réclamation", required = true, defaultValue = "")
                                       @PathVariable String reference) {
        return reclamationConverter.reclamationToReclamationDto(reclamationService.findById(reference).get());
    }

    @ApiOperation(value = "Retourner la liste des reclamations", notes = "", nickname = "findAll")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Liste des clients trouvées", response = ReclamationDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    // Get a list of all reclamation
    @GetMapping
    public List<ReclamationDTO> findAll() {

        return reclamationConverter.ReclamationToReclamationDto(reclamationService.findAll());
    }


}
