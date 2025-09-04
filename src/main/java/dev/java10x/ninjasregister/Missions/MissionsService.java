package dev.java10x.ninjasregister.Missions;

import dev.java10x.ninjasregister.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionsService {

    private final MissionsRepository missionsRepository;
    private final MissionsMapper missionsMapper;

    public MissionsService(MissionsRepository missionsRepository, MissionsMapper missionsMapper) {
        this.missionsRepository = missionsRepository;
        this.missionsMapper = missionsMapper;
    }

    // List all missions
    public List<MissionsDTO> listMissions(){
        List<MissionsModel> missions = missionsRepository.findAll();
        return missions.stream()
                .map(missionsMapper::map)
                .collect(Collectors.toList());
    }

    // List mission by Rank
    public List<MissionsDTO> getMissionByRank(String rank) {
        List<MissionsModel> missionByRank = missionsRepository.findAllByRank(rank);
        return missionByRank.stream()
                .map(missionsMapper::map)
                .toList();
    }

    // Check if mission exists by ID
    public boolean existsMissionById(Long id) {
        return missionsRepository.existsById(id);
    }

    // Get mission by ID
    public MissionsModel getMissionById(Long id) {
        return missionsRepository.findById(id).orElse(null);
    }

    //Add a mission
    public MissionsDTO createMission(MissionsDTO missionDTO) {
        MissionsModel mission =  missionsMapper.map(missionDTO);
        mission = missionsRepository.save(mission);
        return missionsMapper.map(mission);
    }

    // Delete Mission
    public void deleteMissionById(Long id) {
        missionsRepository.deleteById(id);
    }

    // Update Mission
    public MissionsDTO updateMission(MissionsDTO missionDTO, Long id) {
        Optional<MissionsModel> existingMission = missionsRepository.findById(id);
        if (existingMission.isPresent()) {
            MissionsModel missionUpdated = missionsMapper.map(missionDTO);
            missionUpdated.setId(id);
            MissionsModel missionSaved = missionsRepository.save(missionUpdated);
            return missionsMapper.map(missionSaved);
            }
        return null;
    }

}
