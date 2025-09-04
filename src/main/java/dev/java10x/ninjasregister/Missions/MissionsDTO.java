package dev.java10x.ninjasregister.Missions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.ninjasregister.Ninjas.NinjaModel;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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
