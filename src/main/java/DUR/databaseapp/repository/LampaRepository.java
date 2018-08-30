package DUR.databaseapp.repository;

import DUR.databaseapp.model.Lampa;
import DUR.databaseapp.model.Projektor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LampaRepository extends JpaRepository <Lampa, Integer> {
    List<Lampa> findAllByCzasPracyGreaterThan(int czasPracy);
    List<Lampa> findAllByCzasPracyLessThan(int czasPracy);
    List<Lampa> findAllByProjektor(Projektor projektor);
    List<Lampa> findAllByDataKontroliGreaterThan(Date dataKontroli);
    List<Lampa> findAllByDataKontroliLessThan(Date dataKontroli);
    Lampa findFirstByProjektorAndSprawna(Projektor projektor, Boolean sprawna);
}
