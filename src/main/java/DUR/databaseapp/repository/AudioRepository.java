package DUR.databaseapp.repository;


import DUR.databaseapp.model.Audio;
import DUR.databaseapp.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudioRepository extends JpaRepository <Audio, Integer>, JpaSpecificationExecutor<Audio> {
    List<Audio> findAllByTyp(String typ);
    List<Audio> findAllBySala(Sala sala);
}
