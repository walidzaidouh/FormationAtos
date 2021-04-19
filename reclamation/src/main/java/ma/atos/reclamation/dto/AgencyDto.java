package ma.atos.reclamation.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AgencyDto implements Serializable {


    private String placeCode;
    private String name;
    private String bankCode;
    private String swiftCode;
    private boolean disable = false;



}
