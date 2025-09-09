package dev.java10x.ninjasregister.Ninjas;

import dev.java10x.ninjasregister.Missions.MissionsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String name;
    private String email;
    private int age;
    private String ninjaRank;
    private String imgUrl;
    private MissionsModel missions;


}
