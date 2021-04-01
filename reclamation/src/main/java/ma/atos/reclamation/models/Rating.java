package ma.atos.reclamation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor


public class Rating {
    @Id
    private Long id;
    private String commentaire;
    private Double notes;
}
