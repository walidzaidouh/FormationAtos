package ma.atos.reclamation.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends AbstractEntity {
    @Id
    private Long Id;
    private String labelShort;
    private String labelLong;


}
