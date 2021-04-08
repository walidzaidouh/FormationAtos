package ma.atos.reclamation.repositories;

import ma.atos.reclamation.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
