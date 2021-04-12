package ma.atos.reclamation.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Data
public class CategoryDTO {
    @NotNull(message = "Id est obligatoire")
    private Long id;
    @NotNull(message = "labelShort est obligatoire")
    private String labelShort;
    @NotNull(message = "labelLong est obligatoire")
    private String labelLong;
}