package ma.atos.reclamation.Services;

import ma.atos.reclamation.Models.Reclamation;

import java.util.List;
import java.util.Optional;

public interface ReclamationService {
    Reclamation add(Reclamation reclamation);

    Reclamation update(String reference, Reclamation reclamation);

    void deleteById(String reference);

    Optional<Reclamation> findById(String reference);

    List<Reclamation> findAll();


}
