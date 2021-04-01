package ma.atos.reclamation.Service;

import ma.atos.reclamation.Models.Category;
import ma.atos.reclamation.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService{
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
}
