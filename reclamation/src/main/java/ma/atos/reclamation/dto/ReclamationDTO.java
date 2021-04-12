package ma.atos.reclamation.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Validated
@Data
public class ReclamationDTO {
    @NotNull(message = "Reference Note is required")
    private String reference;
    @NotNull(message = "Priority Note is required")
    private String priority;
    @NotNull(message = "Date Note is required")
    private Date date;
    @NotNull(message = "Manager Note is required")
    private String gestionnaire;
    @NotNull(message = "Body is required")
    private String body;
}
