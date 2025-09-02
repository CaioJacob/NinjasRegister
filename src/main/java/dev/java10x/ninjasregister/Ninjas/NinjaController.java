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
    public String createNinja() {
        return "Ninja created";
    }

    // Show all ninjas (READ)
    @GetMapping("/list")
    public List<NinjaModel> listNinjas() {
        return ninjaService.listNinjas();
    }

    // Show ninja by id (READ)
    @GetMapping("/listByID")
    public String showAllNinjasById() {
        return "Show Ninjas by ID";
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
