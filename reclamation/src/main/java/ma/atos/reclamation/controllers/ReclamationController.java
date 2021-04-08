package ma.atos.reclamation.controllers;

import ma.atos.reclamation.converter.ReclamationConverter;
import ma.atos.reclamation.dto.ReclamationDTO;
import ma.atos.reclamation.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamations")
public class ReclamationController {
    @Autowired
    ReclamationService reclamationService;

    @Autowired
    ReclamationConverter reclamationConverter;


    // add reclamation method
    @PostMapping
    public ReclamationDTO add(@RequestBody ReclamationDTO reclamationDTO) {
        return reclamationConverter.reclamationToReclamationDto(reclamationService.add(reclamationConverter.reclamationDtoToReclamation(reclamationDTO)));
    }

    // Update reclamation method
    @PutMapping("/{reference}")
    public ReclamationDTO update(@PathVariable String reference, @RequestBody ReclamationDTO reclamationDTO) {
        return reclamationConverter.reclamationToReclamationDto(reclamationService.update(reference, reclamationConverter.reclamationDtoToReclamation(reclamationDTO)));
    }

    // delete reclamation method
    @DeleteMapping("/{reference}")
    public void deleteById(@PathVariable String reference) {

        reclamationService.deleteById(reference);
    }

    // Get a single reclamation by id
    @GetMapping("/{reference}")
    public ReclamationDTO findById(@PathVariable String reference) {
        return reclamationConverter.reclamationToReclamationDto(reclamationService.findById(reference).get());
    }

    // Get a list of all reclamation
    @GetMapping
    public List<ReclamationDTO> findAll() {

        return reclamationConverter.ReclamationToReclamationDto(reclamationService.findAll());
    }


}
