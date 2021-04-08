package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.CategoryDTO;
import ma.atos.reclamation.models.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter{

    public CategoryDTO FromCategoryToCategoryDto(Category category){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(category, CategoryDTO.class);
    }

    public Category FromCategoryDtoToCategory(CategoryDTO categoryDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(categoryDTO, Category.class);
    }

    public List<CategoryDTO> FromListCategoriesToListCategoriesDto(List<Category> categories){
        ModelMapper mapper =new ModelMapper();
        return categories.stream().map(this::FromCategoryToCategoryDto).collect(Collectors.toList());
    }

    public List<Category> FromListCategoriesToListCategoryDto(List<CategoryDTO> categoryDto){
        ModelMapper mapper =new ModelMapper();
        return categoryDto.stream().map(this::FromCategoryDtoToCategory).collect(Collectors.toList());

    }

}
