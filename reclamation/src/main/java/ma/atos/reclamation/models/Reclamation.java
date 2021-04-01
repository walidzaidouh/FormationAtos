package ma.atos.reclamation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
public class Reclamation {
    @Id
    private String reference;
    private String priority;
    private Date date;
    private String gestionnaire;
    private String body;

}
