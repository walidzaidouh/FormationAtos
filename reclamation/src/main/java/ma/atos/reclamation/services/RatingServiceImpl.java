package ma.atos.reclamation.services;

import ma.atos.reclamation.models.Rating;
import ma.atos.reclamation.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating add(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating update(long id, Rating rating) {
        rating.setId(id);
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteById(long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public Optional<Rating> findById(Long id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }
}
