package dev.java10x.ninjasregister.Missions;

import org.springframework.stereotype.Component;

@Component
public class MissionsMapper {

    public MissionsModel map(MissionsDTO missionsDTO){
        MissionsModel missionsModel = new MissionsModel();
        missionsModel.setId(missionsDTO.getId());
        missionsModel.setName(missionsDTO.getName());
        missionsModel.setDescription(missionsDTO.getDescription());
        missionsModel.setRank(missionsDTO.getRank());
        missionsModel.setNinjas(missionsDTO.getNinjas());
        return missionsModel;
    }

    public MissionsDTO map(MissionsModel missionsModel){
        MissionsDTO missionsDTO = new MissionsDTO();
        missionsDTO.setId(missionsModel.getId());
        missionsDTO.setName(missionsModel.getName());
        missionsDTO.setDescription(missionsModel.getDescription());
        missionsDTO.setRank(missionsModel.getRank());
        missionsDTO.setNinjas(missionsModel.getNinjas());
        return missionsDTO;
    }



}
