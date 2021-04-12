package ma.atos.reclamation.controllers;

import io.swagger.annotations.*;
import ma.atos.reclamation.converter.ReclamationConverter;
import ma.atos.reclamation.dto.ReclamationDTO;
import ma.atos.reclamation.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reclamations")
@Api(value = "Reclamations", tags ={"Reclamations"})
public class ReclamationController {
    @Autowired
    ReclamationService reclamationService;

    @Autowired
    ReclamationConverter reclamationConverter;

    @ApiOperation(value = "Add a complaint", notes = "", nickname = "AddReclamation")
    @ApiResponses(value = {

            @ApiResponse(code = 201, message = "Reclamation added", response = ReclamationDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    // add reclamation method
    @PostMapping
    public ReclamationDTO add(@ApiParam(value = "Claim to add", required = true)@Valid @RequestBody ReclamationDTO reclamationDTO) {
        return reclamationConverter.reclamationToReclamationDto(reclamationService.add(reclamationConverter.reclamationDtoToReclamation(reclamationDTO)));
    }

    @ApiOperation(value = "Modify a modification by its reference;", notes = "", nickname = "updateByReference")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Claim Amended", response = ReclamationDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    // Update reclamation method
    @PutMapping("/{reference}")
    public ReclamationDTO update(@ApiParam(value = "Reference of the complaint", required = true, defaultValue = "")
                                     @PathVariable String reference,
                                 @ApiParam(value = "Reference of the complaint", required = true, defaultValue = "")
                                 @Valid @RequestBody ReclamationDTO reclamationDTO) {
        return reclamationConverter.reclamationToReclamationDto(reclamationService.update(reference, reclamationConverter.reclamationDtoToReclamation(reclamationDTO)));
    }

    @ApiOperation(value = "Delete a complaint by its reference", notes = "", nickname = "deleteByReference")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Complaint deleted", response = ReclamationDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    // delete reclamation method
    @DeleteMapping("/{reference}")
    public void deleteById(@ApiParam(value = "Reference of the complaint", required = true, defaultValue = "")
                               @PathVariable String reference) {

        reclamationService.deleteById(reference);
    }

    @ApiOperation(value = "Return a customer by reference", notes = "", nickname = "findByReference")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Complaint found", response = ReclamationDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    // Get a single reclamation by id
    @GetMapping("/{reference}")
    public ReclamationDTO findById(@ApiParam(value = "Reference of the complaint", required = true, defaultValue = "")
                                       @PathVariable String reference) {
        return reclamationConverter.reclamationToReclamationDto(reclamationService.findById(reference).orElse(null));
    }

    @ApiOperation(value = "Return the list of complaints", notes = "", nickname = "findAll")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "List of clients found", response = ReclamationDTO.class),
            @ApiResponse(code = 400, message = "Syntax of the request is incorrect"),
            @ApiResponse(code = 401, message = "Not allowed"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })

    // Get a list of all reclamation
    @GetMapping
    public List<ReclamationDTO> findAll() {

        return reclamationConverter.listReclamationToReclamationDto(reclamationService.findAll());
    }


}
