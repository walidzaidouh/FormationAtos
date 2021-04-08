package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.CategoryDTO;
import ma.atos.reclamation.models.Category;
import org.modelmapper.ModelMapper;

public class CategoryConverter {
    public CategoryDTO entityToDTO(Category category) {
        /* CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setlabelShort(category.getlabelShort());
        clientDto.setlabelLong(category.getlabelLong());*/

        ModelMapper mapper = new ModelMapper();
        return mapper.map(category, CategoryDTO.class);
    }
}
