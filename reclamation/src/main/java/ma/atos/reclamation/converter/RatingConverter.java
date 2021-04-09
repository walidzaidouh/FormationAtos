package ma.atos.reclamation.converter;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.atos.reclamation.dto.RatingDTO;
import ma.atos.reclamation.dto.ReclamationDTO;
import ma.atos.reclamation.models.Rating;
import ma.atos.reclamation.models.Reclamation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RatingConverter {

        public RatingDTO ratingToRatingDto(Rating rating) {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(rating, RatingDTO.class);
        }

       public List<RatingDTO> ratingToRatingDto(List<Rating> rating) {
        return	rating.stream().map(this::ratingToRatingDto).collect(Collectors.toList());
    }

        public Rating ratingDtoToRating(RatingDTO ratingDto) {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(ratingDto , Rating.class);
        }

        public List<Rating> ratingDtoToRating(List<RatingDTO> ratingDto) {
        return	ratingDto.stream().map(this::ratingDtoToRating).collect(Collectors.toList());
    }


}






