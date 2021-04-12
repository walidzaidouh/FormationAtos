package ma.atos.reclamation.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AbstractEntity {

    @Id
    @NotNull(message = "TDN is required")
    private Long thirdPartyNumber;

    @NotNull(message = "CIN is required")
    private String cin;

    @NotNull(message = "AN is required")
    private Long accountNumber;

    @NotNull(message = "PPM is required")
    private String ppm;

}
