package ma.atos.reclamation.Repositories;

import ma.atos.reclamation.Models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
