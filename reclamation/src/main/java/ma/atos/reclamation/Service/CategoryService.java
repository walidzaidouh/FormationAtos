package ma.atos.reclamation.Service;

import ma.atos.reclamation.Models.Category;
import ma.atos.reclamation.Models.Client;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public abstract List<Category> findAll() ;
    public abstract Category update(int id , Category c);
    public abstract Optional<Category> findById(int id);
    public abstract void deleteById(int id);
}
