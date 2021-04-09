package ma.atos.reclamation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reclamation extends AbstractEntity {
    @Id
    private String reference;
    private String priority;
    private Date date;
    private String gestionnaire;
    private String body;
}
