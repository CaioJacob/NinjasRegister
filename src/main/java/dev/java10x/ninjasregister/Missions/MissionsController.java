package dev.java10x.ninjasregister.Missions;
import dev.java10x.ninjasregister.Ninjas.NinjaDTO;
import dev.java10x.ninjasregister.Ninjas.NinjaModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionsController {

    private final MissionsService missionsService;

    public MissionsController(MissionsService missionsService) {
        this.missionsService = missionsService;
    }

    // Show all missions (READ)
    @GetMapping("/list")
    @Operation(summary = "List all missions", description = "Returns a list of all registered missions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of missions")
    })
    public ResponseEntity<List<MissionsDTO>> listMissions() {
        List<MissionsDTO> missions = missionsService.listMissions();
        return ResponseEntity.ok(missions);
    }

    // Show mission by rank (READ)
    @GetMapping("/list/{rank}")
    @Operation(summary = "Get mission by rank", description = "Returns a list of missions filtered by rank")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missions found successfully"),
            @ApiResponse(responseCode = "404", description = "No missions found with the given rank")
    })
    public ResponseEntity<?> getMissionByRank(
        @Parameter(description = "Rank of the mission to retrieve")
        @PathVariable String rank) {
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
    @Operation(summary = "Create a new mission", description = "Route creates a new mission and inserts into the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mission created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid mission data")
    })
    public ResponseEntity<String> createMission(@RequestBody MissionsDTO mission) {
        MissionsDTO newMission = missionsService.createMission(mission);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Mission created successfully: " + newMission.getName() + ". (ID): " + newMission.getId() + ".");
    }

    // Change mission data (UPDATE)
    @PutMapping("/update/{id}")
    @Operation(summary = "Update mission by ID", description = "Route updates a mission by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mission updated successfully"),
            @ApiResponse(responseCode = "404", description = "Mission not found")
    })
    public ResponseEntity<?> updateMission(
            @Parameter(description = "Mission data to update")
            @RequestBody MissionsDTO missionUpdated,
            @Parameter(description = "ID of the mission to update")
            @PathVariable Long id) {
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
    @Operation(summary = "Delete mission by ID", description = "Deletes a mission from the database by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mission deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Mission not found")
    })
    public ResponseEntity<String> deleteMissionById(
            @Parameter(description = "ID of the mission to delete")
            @PathVariable Long id) {
        if (missionsService.existsMissionById(id)) {
            missionsService.deleteMissionById(id);
            return ResponseEntity.ok("Mission with ID: " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission with ID: " + id + " not found.");
        }
    }
}
