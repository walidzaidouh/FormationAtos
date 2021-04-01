package ma.atos.reclamation.Controllers;

import ma.atos.reclamation.Models.Reclamation;
import ma.atos.reclamation.Service.ReclamationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reclamations")
public class ReclamationController {
    @Autowired
    ReclamationServiceImpl reclamationService;

    // add reclamation method
    @PostMapping
    public Reclamation add(@RequestBody Reclamation reclamation) {
        return reclamationService.add(reclamation);

    }

    // Update reclamation method
    @PutMapping("/{reference}")
    public Reclamation update(@PathVariable String reference, @RequestBody Reclamation reclamation) {

        return reclamationService.update(reference, reclamation);

    }

    // delete reclamation method
    @DeleteMapping("/{reference}")
    public void deleteById(@PathVariable String reference) {
        reclamationService.deleteById(reference);
    }

    // Get a single reclamation by id
    @GetMapping("/{reference}")
    public Optional<Reclamation> findById(@PathVariable String reference) {
        return reclamationService.findById(reference);
    }

    // Get a list of all reclamation
    @GetMapping
    public List<Reclamation> findAll() {
        return reclamationService.findAll();
    }


}
