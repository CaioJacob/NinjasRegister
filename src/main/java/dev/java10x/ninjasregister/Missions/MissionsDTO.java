package dev.java10x.ninjasregister.Missions;

import dev.java10x.ninjasregister.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionsDTO {

    private Long id;
    private String name;
    private String description;
    private String rank;
    private List<NinjaModel> ninjas;

}
