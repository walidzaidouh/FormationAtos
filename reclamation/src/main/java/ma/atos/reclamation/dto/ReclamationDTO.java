package ma.atos.reclamation.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReclamationDTO {
    private String reference;
    private String priority;
    private Date date;
    private String gestionnaire;
    private String body;
}
