package ma.atos.reclamation.Service;

import ma.atos.reclamation.Models.Client;
import ma.atos.reclamation.Models.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {

    public abstract Rating add(Rating rating);
    public abstract Rating update(long id , Rating rating);
    public abstract void deleteById(long id);
    public abstract Optional<Rating> findById(Long id);
    public abstract List<Rating> findAll() ;
}
