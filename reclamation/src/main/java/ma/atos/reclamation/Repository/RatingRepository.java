package ma.atos.reclamation.Repository;

import ma.atos.reclamation.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Long> {
}
