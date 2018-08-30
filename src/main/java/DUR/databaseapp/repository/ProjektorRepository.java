package DUR.databaseapp.repository;

import DUR.databaseapp.model.Lampa;
import DUR.databaseapp.model.Projektor;
import DUR.databaseapp.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjektorRepository extends JpaRepository <Projektor, Integer> {
    List<Projektor> findAllBySala(Sala sala);
    List<Projektor> findAllByModel(String model);
    Projektor findByNumerSeryjny(String numerSeryjny);
}
