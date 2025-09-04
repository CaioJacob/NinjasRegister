package dev.java10x.ninjasregister.Ninjas;
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
    public ResponseEntity<String > createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja created successfully: " + newNinja.getName() + ". (ID): " + newNinja.getId() + ".");
    }

    // Show all ninjas (READ)
    @GetMapping("/list")
    public ResponseEntity<List<NinjaDTO>> listNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Show ninja by id (READ)
    @GetMapping("/list/{id}")
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
    public ResponseEntity<?> updateNinja(@RequestBody  NinjaDTO ninjaUpdated, @PathVariable Long id) {
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
    public ResponseEntity<String> deleteNinjasById(@PathVariable Long id) {
      if (ninjaService.getNinjaById(id) != null) {
          ninjaService.deleteNinjasById(id);
          return ResponseEntity.ok("Ninja with ID: " + id + " deleted successfully.");
      } else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .body("Ninja with ID: " + id + " not found.");
      }

    }


}
