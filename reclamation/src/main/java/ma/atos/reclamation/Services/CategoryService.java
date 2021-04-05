package ma.atos.reclamation.Services;

import ma.atos.reclamation.Models.Category;


import java.util.List;
import java.util.Optional;


public interface CategoryService {

    public abstract Category add(Category category);
    public abstract Category update(int id , Category category);
    public abstract void deleteById(int id);



    public abstract Optional<Category> findById(Long Id);

    public abstract List<Category> findAll() ;

}
