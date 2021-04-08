package ma.atos.reclamation.controllers;


import ma.atos.reclamation.converter.CategoryConverter;
import ma.atos.reclamation.dto.CategoryDTO;
import ma.atos.reclamation.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categories")

public class CategoryController {

    @Autowired

    private CategoryService categoryService;

    @Autowired

    private CategoryConverter categoryConverter;

    @PostMapping

    public CategoryDTO add(@RequestBody CategoryDTO categoryDto) {

        return categoryConverter.FromCategoryToCategoryDto(categoryService.add(categoryConverter.FromCategoryDtoToCategory(categoryDto)));

    }

    @PutMapping("/{Id}")

    public CategoryDTO update(@PathVariable long Id, @RequestBody CategoryDTO categoryDTO) {

        return categoryConverter.FromCategoryToCategoryDto(categoryService.update(Id,categoryConverter.FromCategoryDtoToCategory(categoryDTO)));

    }

    @DeleteMapping("/{Id}")

    public void deleteById(@PathVariable long Id) {
        categoryService.deleteById(Id);
    }

    @GetMapping("/{Id}")

    public CategoryDTO findById(@PathVariable Long Id) {

        return categoryConverter.FromCategoryToCategoryDto(categoryService.findById(Id).get());

    }

    @GetMapping

    public List<CategoryDTO> findAll() {

        return categoryConverter.FromListCategoriesToListCategoriesDto(categoryService.findAll());

    }
}