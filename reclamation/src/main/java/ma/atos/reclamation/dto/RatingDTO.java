package ma.atos.reclamation.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**/
@Validated
@Data
public class RatingDTO {

    @NotNull(message = "id est obligatoire")
    private Long id;
    @NotBlank(message = "Commentaire est obligatoire")
    private String commentaire;
    @NotNull(message = "Note est obligatoire")
    private Double notes;
}
