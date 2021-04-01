package ma.atos.reclamation.Controllers;

import ma.atos.reclamation.Models.Reclamation;
import ma.atos.reclamation.Service.ReclamationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class ReclamationController {
    @Autowired
    ReclamationServiceImpl reclamationService;
    // Get a list of all reclamation
    @GetMapping("/reclamation")
    List<Reclamation> Reclamation() {
        return reclamationService.findAll();
    }
    // Get a single reclamation by id
    @GetMapping("/reclamation/{id}")
    ResponseEntity<?> getGroup(@PathVariable String id) {
        Optional<Reclamation> reclamation = reclamationService.findById(id);
        return reclamation.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/reclamation")
    ResponseEntity<Reclamation> addReclamation(@RequestBody Reclamation reclamation) {
        Reclamation result = reclamationService.add(reclamation);
        return ResponseEntity.ok().body(result);
    }
    // Update reclamation method
    @PutMapping("/reclamation/{id}")
    ResponseEntity<Reclamation> updateReclamation(@PathVariable String id, @RequestBody Reclamation reclamation) {
        Reclamation result = reclamationService.update(id, reclamation);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/reclamation/{id}")
    void deleteReclamation(@PathVariable String id) {
        reclamationService.deleteById(id);
    }
}
