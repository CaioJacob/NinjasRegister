package dev.java10x.ninjasregister.Ninjas;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

     // Add ninja (CREATE)
    @PostMapping("/create")
    public NinjaModel createNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.createNinja(ninja);
    }

    // Show all ninjas (READ)
    @GetMapping("/list")
    public List<NinjaModel> listNinjas() {
        return ninjaService.listNinjas();
    }

    // Show ninja by id (READ)
    @GetMapping("/list/{id}")
    public NinjaModel getNinjaById(@PathVariable Long id) {
        return ninjaService.getNinjaById(id);
    }

    // Change ninja data (UPDATE)
    @PutMapping("/alterID")
    public String alterNinjasById() {
        return "Ninjas Altered";
    }

    // Delete ninja (DELETE)
    @DeleteMapping("/deleteID")
    public String deleteNinjasById() {
        return "Ninja Deleted";
    }


}
