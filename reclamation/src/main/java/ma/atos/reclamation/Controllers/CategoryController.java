package ma.atos.reclamation.Controllers;


import ma.atos.reclamation.Models.Category;
import ma.atos.reclamation.Services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@Configuration

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
    public Category update(@PathVariable int Id , @RequestBody Category category) {

        return categoryService.update(Id,category);

    }

    @DeleteMapping("/{Id}")
    public void deleteById(@PathVariable int Id) {
        categoryService.deleteById(Id);
    }

}