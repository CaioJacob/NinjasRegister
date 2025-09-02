package dev.java10x.ninjasregister.Missions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionsController {

    private MissionsService missionsService;

    public MissionsController(MissionsService missionsService) {
        this.missionsService = missionsService;
    }

    // Show all missions (READ)
    @GetMapping("/list")
    public List<MissionsModel> listMissions() {
        return missionsService.listMissions();
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

    // Delete mission (DELETE)
    @DeleteMapping("/delete")
    public String deleteMission() {
        return "Mission Deleted";
    }

}
