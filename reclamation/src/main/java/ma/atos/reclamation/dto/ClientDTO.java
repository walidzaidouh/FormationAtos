package ma.atos.reclamation.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
@Data
public class ClientDTO {

    @NotNull(message = "ThirdPartyNumber is required")
    private Long thirdPartyNumber;

    @NotBlank(message = "Cin is required")
    @Size(min = 3, max = 20, message = "Cin size is between 10 and 20")
    private String cin;
    @NotNull(message = "AccountNumber is required")
    private Long accountNumber;
    @Size(max = 30)
    private String ppm;

}
