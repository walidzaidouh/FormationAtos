package ma.atos.reclamation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating extends AbstractEntity {
    @Id
    private Long id;
    private String commentaire;
    private Double notes;


}
