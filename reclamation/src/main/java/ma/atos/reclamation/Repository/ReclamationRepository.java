package ma.atos.reclamation.Repository;

import ma.atos.reclamation.Models.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamationRepository extends JpaRepository<Reclamation, String> {
}
