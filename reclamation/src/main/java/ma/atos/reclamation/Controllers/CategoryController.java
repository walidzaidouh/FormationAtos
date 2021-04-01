package ma.atos.reclamation.Controllers;

import ma.atos.reclamation.Models.Category;
import ma.atos.reclamation.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category add(@RequestBody Category category) {
        return categoryService.add(category);

    }

    @PutMapping("/{Id}")
    public Category update(@PathVariable int Id , @RequestBody Category category) {

        return categoryService.update(Id,category);

    }
    @DeleteMapping("/{Id}")

    public void deleteById(@PathVariable int Id) {
        categoryService.deleteById(Id);
    }




}
