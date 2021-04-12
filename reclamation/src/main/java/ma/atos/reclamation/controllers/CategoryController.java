package ma.atos.reclamation.controllers;


import io.swagger.annotations.*;
import ma.atos.reclamation.converter.CategoryConverter;
import ma.atos.reclamation.dto.CategoryDTO;
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


    @ApiOperation(value = "Add a category", notes = "", nickname = "Addcategory")
    @ApiResponses(value = {

            @ApiResponse(code = 201, message = "Category added", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    @PostMapping
    public CategoryDTO add(@ApiParam(value = "Category to add", required = true)
                               @Valid @RequestBody CategoryDTO categoryDto) {
        return categoryConverter.fromCategoryToCategoryDto(categoryService.add(
                categoryConverter.fromCategoryDtoToCategory(categoryDto)));
    }

    @ApiOperation(value = "Change a category by its id", notes = "", nickname = "updateById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Category Modified", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    @PutMapping("/{Id}")
    public CategoryDTO update(@ApiParam(value = "Category to change", required = true) @PathVariable long Id,
                              @ApiParam(value = "Category to change", required = true)
                              @Valid @RequestBody CategoryDTO categoryDTO) {
        return categoryConverter.fromCategoryToCategoryDto(categoryService.update
                (Id,categoryConverter.fromCategoryDtoToCategory(categoryDTO)));
    }

    @ApiOperation(value = "Delete a category by its id", notes = "", nickname = "deleteById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Category deleted", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    @DeleteMapping("/{Id}")
    public void deleteById(@ApiParam(value = "Category to delete", required = true)@PathVariable long Id) {
        categoryService.deleteById(Id);
    }

    @ApiOperation(value = "Return a category by its id", notes = "", nickname = "findById")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Category found", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    @GetMapping("/{Id}")
    public CategoryDTO findById(@ApiParam(value = "Category to find", required = true)@PathVariable Long Id) {
        return categoryConverter.fromCategoryToCategoryDto(categoryService.findById(Id).get());
    }

    @ApiOperation(value = "Return the list of categories", notes = "", nickname = "findAll")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "List of categories found", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    @GetMapping
    public List<CategoryDTO> findAll() {
        return categoryConverter.fromListCategoriesToListCategoriesDto(categoryService.findAll());
    }
}