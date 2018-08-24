package DUR.databaseapp.repository;

import DUR.databaseapp.model.Ekran;
import DUR.databaseapp.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EkranRepository extends JpaRepository <Ekran, Integer> {
    List<Ekran> findAllByModel(String model);
    List<Ekran> findAllBySala(Sala sala);
}
