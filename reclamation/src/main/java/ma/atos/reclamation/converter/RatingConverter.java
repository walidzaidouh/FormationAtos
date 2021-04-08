package ma.atos.reclamation.converter;


import ma.atos.reclamation.dto.RatingDTO;
import ma.atos.reclamation.models.Rating;
import org.modelmapper.ModelMapper;

public class RatingConverter {

        public RatingDTO ratingToRatingDto(Rating rating) {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(rating, RatingDTO.class);
        }

        public Rating ratingDtoToRating(RatingDTO ratingDto) {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(ratingDto , Rating.class);
        }

    }






