package ma.atos.reclamation.repositories;

import ma.atos.reclamation.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
