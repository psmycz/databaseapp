package DUR.databaseapp.repository;

import DUR.databaseapp.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository <Sala, Integer> {
    List<Sala> findAllByBudynek(String budynek);
    Sala findByBudynekAndNumer(String budynek, int numer);
    Sala findBySalaId(int salaId);

}
