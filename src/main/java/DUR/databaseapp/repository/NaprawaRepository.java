package DUR.databaseapp.repository;

import DUR.databaseapp.model.Naprawa;
import DUR.databaseapp.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NaprawaRepository extends JpaRepository <Naprawa, Integer> {
    List<Naprawa> findAllByDataNaprawyGreaterThan(Date dataNaprawy);
    List<Naprawa> findAllByDataNaprawyLessThan(Date dataNaprawy);
    List<Naprawa> findAllBySala(Sala sala);
}
