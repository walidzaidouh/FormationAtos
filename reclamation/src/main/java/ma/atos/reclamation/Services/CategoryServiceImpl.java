package ma.atos.reclamation.Services;

import ma.atos.reclamation.Models.Category;

import ma.atos.reclamation.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category add(Category category) {

        return categoryRepository.save(category);

    }

    @Override
    public Category update(int id, Category category) {

        category.setId(id);
        return categoryRepository.save(category);

    }


    @Override
    public void deleteById(int id) {

        categoryRepository.deleteById(id);

    }

    @Override
    public Optional<Category> findById(Integer Id) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> findById(int Id) {
        return categoryRepository.findById(Id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
