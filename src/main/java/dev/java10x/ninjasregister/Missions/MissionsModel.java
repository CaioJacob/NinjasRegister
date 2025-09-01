package dev.java10x.ninjasregister.Missions;

import dev.java10x.ninjasregister.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missions")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String rank;

    // @OneToMany - The mission can have several ninjas!
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninjas;


}
