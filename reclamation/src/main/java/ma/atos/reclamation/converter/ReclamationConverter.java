package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.ReclamationDTO;
import ma.atos.reclamation.models.Reclamation;
import org.modelmapper.ModelMapper;

public class ReclamationConverter {
    public ReclamationDTO reclamationToReclamationDto(Reclamation reclamation) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(reclamation, ReclamationDTO.class);
    }

    public Reclamation reclamationDtoToReclamation(ReclamationDTO reclamationDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(reclamationDTO, Reclamation.class);
    }
}
