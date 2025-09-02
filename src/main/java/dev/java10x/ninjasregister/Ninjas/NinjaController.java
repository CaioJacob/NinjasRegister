package dev.java10x.ninjasregister.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/welcome")
    public String Welcome() {
        return "This is my first message on this route";
    }

    // Add ninja (CREATE)
    @PostMapping("/create")
    public String createNinja() {
        return "Ninja created";
    }

    // Show all ninjas (READ)
    @GetMapping("/list")
    public String showAllNinjas() {
        return "Show Ninjas";
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
