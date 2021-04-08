package ma.atos.reclamation.dto;

import lombok.Data;
/**/

@Data
public class RatingDTO {
    private Long id;
    private String commentaire;
    private Double notes;
}
