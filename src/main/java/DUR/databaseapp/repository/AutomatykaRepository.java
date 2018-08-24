package DUR.databaseapp.repository;

import DUR.databaseapp.model.Automatyka;
import DUR.databaseapp.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomatykaRepository extends JpaRepository <Automatyka, Integer> {
    List<Automatyka> findAllByNazwa(String nazwa);
    List<Automatyka> findAllBySala(Sala sala);
}
