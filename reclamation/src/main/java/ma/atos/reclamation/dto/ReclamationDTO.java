package ma.atos.reclamation.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Validated
@Data
public class ReclamationDTO {
    @NotNull(message = "reference est obligatoire")
    private String reference;
    @NotNull(message = "priority est obligatoire")
    private String priority;
    @NotNull(message = "date est obligatoire")
    private Date date;
    @NotNull(message = "gestionnaire est obligatoire")
    private String gestionnaire;
    @NotNull(message = "body est obligatoire")
    private String body;
}
