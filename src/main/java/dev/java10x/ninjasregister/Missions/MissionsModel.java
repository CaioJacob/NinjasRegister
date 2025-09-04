package dev.java10x.ninjasregister.Missions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.ninjasregister.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "rank")
    private String rank;

    // @OneToMany - The mission can have several ninjas!
    @OneToMany(mappedBy = "missions")
    @JsonIgnore
    private List<NinjaModel> ninjas;


}
