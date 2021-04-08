package ma.atos.reclamation.services;

import ma.atos.reclamation.models.Reclamation;

import java.util.List;
import java.util.Optional;

public interface ReclamationService {
    Reclamation add(Reclamation reclamation);

    Reclamation update(String reference, Reclamation reclamation);

    void deleteById(String reference);

    Optional<Reclamation> findById(String reference);

    List<Reclamation> findAll();


}
