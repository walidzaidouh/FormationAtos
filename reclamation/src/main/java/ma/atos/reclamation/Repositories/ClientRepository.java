package ma.atos.reclamation.Repositories;

import ma.atos.reclamation.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
