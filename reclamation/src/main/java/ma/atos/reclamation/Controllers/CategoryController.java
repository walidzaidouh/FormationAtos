package ma.atos.reclamation.Controllers;


import ma.atos.reclamation.Models.Category;
import ma.atos.reclamation.Services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/categories")

public class CategoryController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CategoryServiceImpl categoryService;

    @PostMapping
    public Category add(@RequestBody Category category) {
        return categoryService.add(category);

    }

    @PutMapping("/{Id}")
    public Category update(@PathVariable Long Id, @RequestBody Category category) {

        return categoryService.update(Id, category);

    }

    @DeleteMapping("/{Id}")
    public void deleteById(@PathVariable Long Id) {
        categoryService.deleteById(Id);
    }

    @GetMapping("/{Id}")
    public Optional<Category> findById(@PathVariable Long Id) {
        return categoryService.findById(Id);
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

}