package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.ReclamationDTO;
import ma.atos.reclamation.models.Reclamation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReclamationConverter {

    public ReclamationDTO reclamationToReclamationDto(Reclamation reclamation) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(reclamation, ReclamationDTO.class);
    }

    public List<ReclamationDTO> listReclamationToReclamationDto(List<Reclamation> reclamation) {
        return reclamation.stream().map(this::reclamationToReclamationDto).collect(Collectors.toList());
    }

    public Reclamation reclamationDtoToReclamation(ReclamationDTO reclamationDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(reclamationDTO, Reclamation.class);
    }

    public List<Reclamation> listReclamationDtoToReclamation(List<ReclamationDTO> reclamationDTO) {
        return reclamationDTO.stream().map(this::reclamationDtoToReclamation).collect(Collectors.toList());
    }

}
