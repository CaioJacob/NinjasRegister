package dev.java10x.ninjasregister.Missions;

import dev.java10x.ninjasregister.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MissionsService {

    private MissionsRepository missionsRepository;

    public MissionsService(MissionsRepository missionsRepository) {
        this.missionsRepository = missionsRepository;
    }

    // List all missions
    public List<MissionsModel> listMissions(){
        return missionsRepository.findAll();
    }

    // List mission by Rank
    public List<MissionsModel> getMissionByRank(String rank) {
        return missionsRepository.findAllByRank(rank);
    }

    //Add a mission
    public MissionsModel createMission(MissionsModel mission) {
        return missionsRepository.save(mission);
    }

    // Delete Mission - It has to be a method void
    public void deleteMissionById(Long id) {
        missionsRepository.deleteById(id);
    }

}
