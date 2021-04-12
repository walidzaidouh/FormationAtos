package ma.atos.reclamation.services;

import ma.atos.reclamation.models.Category;

import java.util.List;
import java.util.Optional;


public interface CategoryService {

    public abstract Category add(Category category);

    public abstract Category update(Long id, Category category);

    public abstract void deleteById(Long id);


    public abstract Optional<Category> findById(Long id);

    public abstract List<Category> findAll();

}
