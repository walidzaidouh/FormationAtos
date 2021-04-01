package ma.atos.reclamation.Services;

import ma.atos.reclamation.Models.Category;
import ma.atos.reclamation.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
