package dev.java10x.ninjasregister.Missions;

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

}
