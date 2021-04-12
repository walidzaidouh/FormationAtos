package ma.atos.reclamation.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
@Data
public class ClientDTO {

    @NotNull(message = "ThirdPartyNumber est obligatoire")
    private Long thirdPartyNumber;

    @NotBlank(message = "Cin est obligatoire")
    @Size(min = 3, max = 20, message = "Taille cin est entre 10 et 20")
    private String cin;
    @NotNull(message = "AccountNumber est obligatoire")
    private Long accountNumber;
    @Size(max = 30)
    private String ppm;

}
