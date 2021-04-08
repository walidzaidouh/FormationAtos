package ma.atos.reclamation.repositories;

import ma.atos.reclamation.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
