package ma.atos.reclamation.converter;


import ma.atos.reclamation.dto.RatingDTO;
import ma.atos.reclamation.models.Rating;

public class RatingConverter {
    public RatingDTO ratingToDtoRating(Rating rating){
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setCommentaire(rating.getCommentaire());
        ratingDTO.setNotes(ratingDTO.getNotes());
        return ratingDTO;
    }
}

