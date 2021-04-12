package ma.atos.reclamation.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**/
@Validated
@Data
public class RatingDTO {

    @NotNull(message = "Id is required")
    private Long id;
    @NotBlank(message = "Comment is required")
    private String commentaire;
    @NotNull(message = "Note is required")
    private Double notes;
}
