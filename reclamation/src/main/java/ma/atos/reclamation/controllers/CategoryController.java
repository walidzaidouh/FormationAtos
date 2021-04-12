package ma.atos.reclamation.controllers;


import io.swagger.annotations.*;
import ma.atos.reclamation.converter.CategoryConverter;
import ma.atos.reclamation.dto.CategoryDTO;
import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/categories")
@Api(value = "Category", tags ={"Category"})

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryConverter categoryConverter;


    @ApiOperation(value = "Ajouter une catégorie", notes = "", nickname = "AjouterCatégorie")
    @ApiResponses(value = {

            @ApiResponse(code = 201, message = "Catégorie ajoutée", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    @PostMapping
    public CategoryDTO add(@ApiParam(value = "Catégorie à ajouter", required = true)
                               @Valid @RequestBody CategoryDTO categoryDto) {
        return categoryConverter.FromCategoryToCategoryDto(categoryService.add(
                categoryConverter.FromCategoryDtoToCategory(categoryDto)));
    }

    @ApiOperation(value = "Modifier une catégorie par son id", notes = "", nickname = "updateById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Catégorie Modifié", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })
    @PutMapping("/{Id}")
    public CategoryDTO update(@ApiParam(value = "Catégorie à modifier", required = true) @PathVariable long Id,
                              @ApiParam(value = "Catégorie à modifier", required = true)
                              @Valid @RequestBody CategoryDTO categoryDTO) {
        return categoryConverter.FromCategoryToCategoryDto(categoryService.update
                (Id,categoryConverter.FromCategoryDtoToCategory(categoryDTO)));
    }

    @ApiOperation(value = "Supprimer une catégorie par son id", notes = "", nickname = "deleteById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Catégorie supprimé", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })
    @DeleteMapping("/{Id}")
    public void deleteById(@ApiParam(value = "Catégorie à supprimer", required = true)@PathVariable long Id) {
        categoryService.deleteById(Id);
    }

    @ApiOperation(value = "Retourner une catégorie par son id", notes = "", nickname = "findById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Catégorie trouvé", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })
    @GetMapping("/{Id}")
    public CategoryDTO findById(@ApiParam(value = "Catégorie à trouver", required = true)@PathVariable Long Id) {
        return categoryConverter.FromCategoryToCategoryDto(categoryService.findById(Id).get());
    }

    @ApiOperation(value = "Retourner la liste des catégories", notes = "", nickname = "findAll")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Liste des catégories trouvées", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Syntaxe de la requete  est erronée"),
            @ApiResponse(code = 401, message = "Non autorisés"),
            @ApiResponse(code = 403, message = "Accès refusé"),
            @ApiResponse(code = 404, message = "Ressource non trouvée"),
            @ApiResponse(code = 500, message = "Erreur interne du serveur")

    })

    @GetMapping
    public List<CategoryDTO> findAll() {
        return categoryConverter.FromListCategoriesToListCategoriesDto(categoryService.findAll());
    }
}