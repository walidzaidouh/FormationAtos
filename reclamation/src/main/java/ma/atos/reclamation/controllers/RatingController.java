package ma.atos.reclamation.controllers;

import ma.atos.reclamation.converter.RatingConverter;
import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.dto.RatingDTO;
import ma.atos.reclamation.models.Rating;
import ma.atos.reclamation.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")

public class RatingController {
    @Autowired
    private RatingService ratingService;
    @Autowired
    private RatingConverter ratingConverter;

    @PostMapping

        public RatingDTO add(@RequestBody RatingDTO ratingDto) {
            return ratingConverter.ratingToRatingDto(ratingService.add(ratingConverter.ratingDtoToRating(ratingDto)));
        }


    @PutMapping("/{id}")
    public RatingDTO update(@PathVariable long id, @RequestBody RatingDTO ratingDTO) {
        return ratingConverter.ratingToRatingDto(ratingService.update(id, ratingConverter.ratingDtoToRating(ratingDTO)));

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        ratingService.deleteById(id);
    }

    @GetMapping("/{id}")
    public RatingDTO findById(@PathVariable Long id) {
        return ratingConverter.ratingToRatingDto(ratingService.findById(id).get());
    }

    @GetMapping
    public List<RatingDTO> findAll() {
        return ratingConverter.ratingToRatingDto(ratingService.findAll());
    }


}
