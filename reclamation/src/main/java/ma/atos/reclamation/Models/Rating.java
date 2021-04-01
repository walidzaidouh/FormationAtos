package ma.atos.reclamation.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Rating {
    @Id
    private Long id;
    private String commentaire;
    private Double notes;
}
