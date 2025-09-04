package dev.java10x.ninjasregister.Ninjas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

     // Add ninja (CREATE)
    @PostMapping("/create")
    @Operation(summary = "Creates a new ninja", description = "Route creates a new ninja and inserts into the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja created successfully"),
            @ApiResponse(responseCode = "400", description = "Ninja Creation Error")
    })
    public ResponseEntity<String > createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja created successfully: " + newNinja.getName() + ". (ID): " + newNinja.getId() + ".");
    }

    // Show all ninjas (READ)
    @GetMapping("/list")
    @Operation(summary = "List all ninjas", description = "Returns a list of all registered ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of ninjas")
    })
    public ResponseEntity<List<NinjaDTO>> listNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Show ninja by id (READ)
    @GetMapping("/list/{id}")
    @Operation(summary = "Ninja list by ID", description = "Ninja list route a ninja by your id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja found successfully"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    public ResponseEntity<?> getNinjaById(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.getNinjaById(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with id: " + id + " does not exist in our registration!");
        }

    }

    // Change ninja data (UPDATE)
    @PutMapping("/update/{id}")
    @Operation(summary = "Update Ninja by ID", description = "Route updates a ninja by your id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja updated successfully"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    public ResponseEntity<?> updateNinja(
            @Parameter(description = "User sends the ninja data to be updated in the body of the request")
            @RequestBody  NinjaDTO ninjaUpdated,
            @Parameter (description = "User sends the id on the path of request")
            @PathVariable Long id) {

        NinjaDTO ninja = ninjaService.updateNinja(ninjaUpdated, id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with id: " + id + " does not exist in our registration!");
        }
    }

    // Delete ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete ninja by ID", description = "Deletes a ninja from the database by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    public ResponseEntity<String> deleteNinjasById(
        @Parameter(description = "ID of the ninja to delete")
        @PathVariable Long id) {
      if (ninjaService.getNinjaById(id) != null) {
          ninjaService.deleteNinjasById(id);
          return ResponseEntity.ok("Ninja with ID: " + id + " deleted successfully.");
      } else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .body("Ninja with ID: " + id + " not found.");
      }

    }


}
