package DUR.databaseapp.repository;

import DUR.databaseapp.model.Sala;
import DUR.databaseapp.model.Zlacze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZlaczeRepository extends JpaRepository <Zlacze, Integer> {
    List<Zlacze> findAllByNazwa(String nazwa);
    List<Zlacze> findAllBySala(Sala sala);
}
