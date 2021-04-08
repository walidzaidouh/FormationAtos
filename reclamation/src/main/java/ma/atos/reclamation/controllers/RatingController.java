package ma.atos.reclamation.controllers;

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

    @PostMapping
    public Rating add(@RequestBody Rating rating) {
        return ratingService.add(rating);
    }

    @PutMapping("/{id}")
    public Rating update(@PathVariable long id, @RequestBody Rating rating) {
        return ratingService.update(id, rating);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        ratingService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Rating> findById(@PathVariable Long id) {
        return ratingService.findById(id);
    }

    @GetMapping
    public List<Rating> findAll() {
        return ratingService.findAll();
    }


}
