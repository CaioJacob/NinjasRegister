package dev.java10x.ninjasregister.Missions;
import dev.java10x.ninjasregister.Ninjas.NinjaDTO;
import dev.java10x.ninjasregister.Ninjas.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissionsDTO>> listMissions() {
        List<MissionsDTO> missions = missionsService.listMissions();
        return ResponseEntity.ok(missions);
    }

    // Show mission by rank (READ)
    @GetMapping("/list/{rank}")
    public ResponseEntity<?> getMissionByRank(@PathVariable String rank) {
        List<MissionsDTO> missions = missionsService.getMissionByRank(rank);
        if (missions != null) {
            return ResponseEntity.ok(missions);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission with Rank " + rank + " does not exist in our registration!");
        }
    }

    // Add mission (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> createMission(@RequestBody MissionsDTO mission) {
        MissionsDTO newMission = missionsService.createMission(mission);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Mission created successfully: " + newMission.getName() + ". (ID): " + newMission.getId() + ".");
    }

    // Change mission data (UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMission(@RequestBody MissionsDTO missionUpdated, @PathVariable Long id) {
        MissionsDTO mission = missionsService.updateMission(missionUpdated, id);
        if (mission != null) {
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission with id: " + id + " does not exist in our registration!");
        }
    }

    // Delete mission (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMissionById(@PathVariable Long id) {
        if (missionsService.existsMissionById(id)) {
            missionsService.deleteMissionById(id);
            return ResponseEntity.ok("Mission with ID: " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission with ID: " + id + " not found.");
        }
    }
}
