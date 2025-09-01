package dev.java10x.ninjasregister.Missions;

import dev.java10x.ninjasregister.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missions")
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


    public MissionsModel() {
    }

    public MissionsModel(Long id, String name, String missionDescription, String missionRank) {
        this.id = id;
        this.name = name;
        this.description = missionDescription;
        this.rank = missionRank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
