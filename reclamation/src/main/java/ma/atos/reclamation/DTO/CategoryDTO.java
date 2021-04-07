package ma.atos.reclamation.DTO;

import lombok.Data;

import javax.persistence.Id;

@Data
public class CategoryDTO {
    @javax.persistence.Id
    private Long Id;
    private String labelShort;
    private String labelLong;

}