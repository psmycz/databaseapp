package DUR.databaseapp.repository;

import DUR.databaseapp.model.Sala;
import DUR.databaseapp.model.Wyposazenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WyposazenieRepository extends JpaRepository<Wyposazenie,Integer> {
    Wyposazenie findBySala(Sala sala);
}
