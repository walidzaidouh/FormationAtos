package ma.atos.reclamation.Repositories;

import ma.atos.reclamation.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
