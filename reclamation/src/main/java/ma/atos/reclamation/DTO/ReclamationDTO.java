package ma.atos.reclamation.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ReclamationDTO {
    private String reference;
    private String priority;
    private Date date;
    private String body;
}
