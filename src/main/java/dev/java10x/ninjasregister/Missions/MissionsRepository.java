package dev.java10x.ninjasregister.Missions;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MissionsRepository extends JpaRepository<MissionsModel, Long> {

    List<MissionsModel> findAllByRank (String rank);

}
