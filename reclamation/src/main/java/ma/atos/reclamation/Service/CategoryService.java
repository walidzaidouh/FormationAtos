package ma.atos.reclamation.Service;

import ma.atos.reclamation.Models.Category;


public interface CategoryService {

    public abstract Category add(Category category);
    public abstract Category update(int id , Category c);
    public abstract void deleteById(int id);

}
