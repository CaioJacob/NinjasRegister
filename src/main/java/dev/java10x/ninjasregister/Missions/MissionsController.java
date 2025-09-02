package dev.java10x.ninjasregister.Missions;
import dev.java10x.ninjasregister.Ninjas.NinjaModel;
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

    // Show mission by rank (READ)
    @GetMapping("/list/{rank}")
    public List<MissionsModel> getMissionByRank(@PathVariable String rank) {
        return missionsService.getMissionByRank(rank);
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
