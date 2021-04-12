package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.CategoryDTO;
import ma.atos.reclamation.models.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter{

    public CategoryDTO fromCategoryToCategoryDto(Category category){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(category, CategoryDTO.class);
    }

    public Category fromCategoryDtoToCategory(CategoryDTO categoryDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(categoryDTO, Category.class);
    }

    public List<CategoryDTO> fromListCategoriesToListCategoriesDto(List<Category> categories){
        return categories.stream().map(this::fromCategoryToCategoryDto).collect(Collectors.toList());
    }

    public List<Category> fromListCategoriesToListCategoryDto(List<CategoryDTO> categoryDto){
        return categoryDto.stream().map(this::fromCategoryDtoToCategory).collect(Collectors.toList());

    }

}
