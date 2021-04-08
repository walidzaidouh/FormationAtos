package ma.atos.reclamation.services;

import ma.atos.reclamation.models.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {

    public abstract Rating add(Rating rating);

    public abstract Rating update(long id, Rating rating);

    public abstract void deleteById(long id);

    public abstract Optional<Rating> findById(Long id);

    public abstract List<Rating> findAll();
}
