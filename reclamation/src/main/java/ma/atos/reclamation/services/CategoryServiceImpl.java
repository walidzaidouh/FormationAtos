package ma.atos.reclamation.services;

import ma.atos.reclamation.models.Category;
import ma.atos.reclamation.repositories.CategoryRepository;
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
    public Category update(Long id, Category category) {

        category.setId(id);
        return categoryRepository.save(category);

    }


    @Override
    public void deleteById(Long id) {

        categoryRepository.deleteById(id);

    }


    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
