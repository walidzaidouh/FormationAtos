package ma.atos.reclamation.Repositories;

import ma.atos.reclamation.Models.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation, String> {
}
