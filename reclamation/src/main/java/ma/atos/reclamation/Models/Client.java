package ma.atos.reclamation.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor

public class Client {
    @Id
    private Long thirdPartyNumber;
    private String cin;
    private Long accountNumber;
    private String ppm;


}
