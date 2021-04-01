package ma.atos.reclamation.Repository;

import ma.atos.reclamation.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
