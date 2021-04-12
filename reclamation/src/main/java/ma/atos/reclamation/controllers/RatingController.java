package ma.atos.reclamation.controllers;

import io.swagger.annotations.*;
import ma.atos.reclamation.converter.RatingConverter;
import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.dto.RatingDTO;
import ma.atos.reclamation.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ratings")
@Api(value = "Ratings", tags ={"Ratings"} )


public class RatingController {
    @Autowired
    private RatingService ratingService;
    @Autowired
    private RatingConverter ratingConverter;



    @ApiOperation(value = "Ajouter un rating", notes = "", nickname = "AjouterRating")
    @ApiResponses(value = {

            @ApiResponse(code = 201, message = "Rating ajouté", response = RatingDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })
    @PostMapping
    public RatingDTO add(@ApiParam(value = "Rating à ajouter", required = true) @Valid @RequestBody RatingDTO ratingDto) {
        return ratingConverter.ratingToRatingDto(ratingService.add(ratingConverter.ratingDtoToRating(ratingDto)));
    }

    @ApiOperation(value = "Modifier un rating", notes = "", nickname = "ModifierRating")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Rating modifié", response = RatingDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    @PutMapping("/{id}")
    public RatingDTO update(@ApiParam(value = "Id du client", required = true, defaultValue = "")@PathVariable long id,
                            @ApiParam(value = "Objet avec les données de modifications", required = true) @Valid @RequestBody RatingDTO ratingDTO) {
        return ratingConverter.ratingToRatingDto(ratingService.update(id, ratingConverter.ratingDtoToRating(ratingDTO)));

    }

    @ApiOperation(value = "Supprimer un rating", notes = "", nickname = "SupprimerRating")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Rating supprimé", response = RatingDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    @DeleteMapping("/{id}")
    public void deleteById(@ApiParam(value = "Id du client", required = true, defaultValue = "")@PathVariable long id) {
        ratingService.deleteById(id);
    }

    @ApiOperation(value = "Retourner un rating par son id", notes = "", nickname = "RetournerRating")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Rating trouvé", response = RatingDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    @GetMapping("/{id}")
    public RatingDTO findById(@ApiParam(value = "Id du client", required = true, defaultValue = "")@PathVariable Long id) {
        return ratingConverter.ratingToRatingDto(ratingService.findById(id).get());
    }

    @ApiOperation(value = "Retourner la liste des ratings", notes = "", nickname = "RetournerListeRatings")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Ratings trouvé", response = RatingDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })
    @GetMapping
    public List<RatingDTO> findAll() {
        return ratingConverter.ratingToRatingDto(ratingService.findAll());
    }


}
