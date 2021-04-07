package ma.atos.reclamation.DTO;

import lombok.Data;


@Data
public class RatingDTO {
    private Long id;
    private String commentaire;
    private Double notes;
}
