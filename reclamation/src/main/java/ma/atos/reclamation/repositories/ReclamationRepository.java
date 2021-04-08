package ma.atos.reclamation.repositories;

import ma.atos.reclamation.models.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamationRepository extends JpaRepository<Reclamation, String> {
}
