package ma.atos.reclamation.Services;

import ma.atos.reclamation.Models.Reclamation;

import java.util.List;
import java.util.Optional;

public interface ReclamationService {
    public abstract Reclamation add(Reclamation reclamation);

    public abstract Reclamation update(String reference, Reclamation reclamation);

    public abstract void deleteById(String reference);

    public abstract Optional<Reclamation> findById(String reference);

    public abstract List<Reclamation> findAll();


}
