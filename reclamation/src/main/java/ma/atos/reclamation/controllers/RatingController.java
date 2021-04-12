package ma.atos.reclamation.controllers;

import io.swagger.annotations.*;
import ma.atos.reclamation.converter.RatingConverter;
import ma.atos.reclamation.dto.RatingDTO;
import ma.atos.reclamation.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ratings")
@Api(value = "Ratings", tags ={"Ratings"} )


public class RatingController {
    @Autowired
    private RatingService ratingService;
    @Autowired
    private RatingConverter ratingConverter;



    @ApiOperation(value = "Add a rating", notes = "", nickname = "AddRating")
    @ApiResponses(value = {

            @ApiResponse(code = 201, message = "Rating added", response = RatingDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    @PostMapping
    public RatingDTO add(@ApiParam(value = "Rating to add", required = true) @Valid @RequestBody RatingDTO ratingDto) {
        return ratingConverter.ratingToRatingDto(ratingService.add(ratingConverter.ratingDtoToRating(ratingDto)));
    }

    @ApiOperation(value = "Change a rating", notes = "", nickname = "ChangeRating")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Rating changed", response = RatingDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    @PutMapping("/{id}")
    public RatingDTO update(@ApiParam(value = "Rating id", required = true, defaultValue = "")@PathVariable long id,
                            @ApiParam(value = "Object with modification data", required = true) @Valid @RequestBody RatingDTO ratingDTO) {
        return ratingConverter.ratingToRatingDto(ratingService.update(id, ratingConverter.ratingDtoToRating(ratingDTO)));

    }

    @ApiOperation(value = "Delete a rating", notes = "", nickname = "DeleteRating")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Rating deleted", response = RatingDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    @DeleteMapping("/{id}")
    public void deleteById(@ApiParam(value = "Id rating", required = true, defaultValue = "")@PathVariable long id) {
        ratingService.deleteById(id);
    }

    @ApiOperation(value = "Return a rating by its id", notes = "", nickname = "ReturnRating")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Rating find", response = RatingDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    @GetMapping("/{id}")
    public RatingDTO findById(@ApiParam(value = "Id rating", required = true, defaultValue = "")@PathVariable Long id) {
        return ratingConverter.ratingToRatingDto(ratingService.findById(id).get());
    }

    @ApiOperation(value = "Return the list of ratings", notes = "", nickname = "ReturnListRatings")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Ratings finds", response = RatingDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    @GetMapping
    public List<RatingDTO> findAll() {
        return ratingConverter.ratingToRatingDto(ratingService.findAll());
    }


}
