package dev.java10x.ninjasregister.Ninjas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.ninjasregister.Missions.MissionsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_register")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "age")
    private int age;

    // @ManyToOne - The ninja has one only mission!
    @ManyToOne
    @JoinColumn(name = "missions_id") // Foreing Key
    private MissionsModel missions;





}

