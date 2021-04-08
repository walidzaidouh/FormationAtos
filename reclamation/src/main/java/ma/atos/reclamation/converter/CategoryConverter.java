package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.CategoryDTO;
import ma.atos.reclamation.dto.ReclamationDTO;
import ma.atos.reclamation.models.Category;
import ma.atos.reclamation.models.Reclamation;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryConverter {
    public CategoryDTO categoryToCategoryDto(Category category) {
        /* CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setlabelShort(category.getlabelShort());
        clientDto.setlabelLong(category.getlabelLong());*/

        ModelMapper mapper = new ModelMapper();
        return mapper.map(category, CategoryDTO.class);
    }
    public List<CategoryDTO> CategoryToCategoryDto(List<Category> category) {
        return	category.stream().map(this::categoryToCategoryDto).collect(Collectors.toList());
    }

    public Category categoryToCategoryDto(CategoryDTO categoryDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(categoryDTO, Category.class);
    }
    public List<Category> categoryToCategoryDto(List<CategoryDTO> categoryDTO) {
        return	categoryDTO.stream().map(this::categoryToCategoryDto).collect(Collectors.toList());
    }

}
