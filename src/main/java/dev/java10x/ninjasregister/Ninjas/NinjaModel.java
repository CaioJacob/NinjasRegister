package dev.java10x.ninjasregister.Ninjas;

import dev.java10x.ninjasregister.Missions.MissionsModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_register")
public class NinjaModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String email;

        private int age;

       // @ManyToOne - The ninja has one only mission!
       @ManyToOne
       @JoinColumn(name = "missions_id") // Foreing Key
       private MissionsModel missions;

    public NinjaModel() {
    }

    public NinjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
