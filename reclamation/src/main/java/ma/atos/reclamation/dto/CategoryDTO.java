package ma.atos.reclamation.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Data
public class CategoryDTO {
    @NotNull(message = "Id is required")
    private Long id;
    @NotNull(message = "labelShort is required")
    private String labelShort;
    @NotNull(message = "labelLong is required")
    private String labelLong;
}