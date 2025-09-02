package dev.java10x.ninjasregister.Missions;

import org.springframework.stereotype.Service;
import java.util.List;

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

}
