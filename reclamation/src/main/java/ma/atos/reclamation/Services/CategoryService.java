package ma.atos.reclamation.Services;

import ma.atos.reclamation.Models.Category;
import ma.atos.reclamation.Models.Client;

import java.util.List;
import java.util.Optional;


public interface CategoryService {

    public abstract Category add(Category category);
    public abstract Category update(int id , Category c);
    public abstract void deleteById(int id);

    Optional<Category> findById(Integer Id);

    public abstract Optional<Category> findById(int Id);

    public abstract List<Category> findAll() ;

}
