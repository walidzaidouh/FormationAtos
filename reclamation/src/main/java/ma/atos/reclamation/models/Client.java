package ma.atos.reclamation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Client")
public class Client {
    @Id
    private Long thirdPartyNumber;
    private String cin;
    private Long accountNumber;
    private String ppm;

}
