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

    // Add mission (CREATE)
    @PostMapping("/create")
    public MissionsDTO createMission(@RequestBody MissionsDTO mission) {
        return missionsService.createMission(mission);
    }

    // Change mission data (UPDATE)
    @PutMapping("/update/{id}")
    public MissionsModel updateMission(@RequestBody  MissionsModel missionUpdated, @PathVariable Long id) {
        return missionsService.updateMission(missionUpdated, id);
    }

    // Delete mission (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteMissionById(@PathVariable Long id) {
        missionsService.deleteMissionById(id);
    }

}
