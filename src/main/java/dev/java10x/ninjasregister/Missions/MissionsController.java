package dev.java10x.ninjasregister.Missions;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
public class MissionsController {

    // Show all ninjas (READ)
    @GetMapping("/list")
    public String listMissions() {
        return "List of missions";
    }

    // Add Mission (CREATE)
    @PostMapping("/create")
    public String createMission() {
        return "Mission created";
    }

    // Change Mission data (UPDATE)
    @PutMapping("/alter")
    public String alterMission() {
        return "Mission Altered";
    }

    // Delete ninja (DELETE)
    @DeleteMapping("/delete")
    public String deleteMission() {
        return "Mission Deleted";
    }

}
