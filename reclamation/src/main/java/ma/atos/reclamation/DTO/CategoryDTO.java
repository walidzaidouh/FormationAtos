package ma.atos.reclamation.DTO;

import lombok.Data;

import javax.persistence.Id;

@Data
public class CategoryDTO {
    private String labelShort;
    private String labelLong;

}