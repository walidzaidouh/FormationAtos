package ma.atos.reclamation.Services;

import ma.atos.reclamation.Models.Category;
import ma.atos.reclamation.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category update(int id, Category category) {

        category.setId(id);
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(int id) {

        return categoryRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);

    }
}
