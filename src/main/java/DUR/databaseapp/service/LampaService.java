package DUR.databaseapp.service;


import DUR.databaseapp.model.Lampa;
import DUR.databaseapp.repository.LampaRepository;
import DUR.databaseapp.repository.ProjektorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class LampaService {

    @Autowired
    private LampaRepository lampaRepository;
    @Autowired
    private ProjektorRepository projektorRepository;

    public Lampa findById (int id){return lampaRepository.getOne(id);}

    public List <Lampa> findAllByCzasPracyGreaterThan(int czasPracy){return lampaRepository.findAllByCzasPracyGreaterThan(czasPracy);}

    public List <Lampa> findAllByCzasPracyLessThan(int czasPracy){return lampaRepository.findAllByCzasPracyLessThan(czasPracy);}

    public List <Lampa> findAllBySprawna(Boolean sprawna){return lampaRepository.findAllBySprawna(sprawna);}

    public List <Lampa> findAllByProjektorId(int projektorId){return lampaRepository.findAllByProjektor(projektorRepository.getOne(projektorId));}

    public List <Lampa> findAllByDataKontroliGreaterThan(Date dataKontroli){return lampaRepository.findAllByDataKontroliGreaterThan(dataKontroli);}

    public List <Lampa> findAllByDataKontroliLessThan(Date dataKontroli){return lampaRepository.findAllByDataKontroliLessThan(dataKontroli);}

    public List <Lampa> findAllByProjektorIdAndSprawna(int projektorId, Boolean sprawna){
        return lampaRepository.findAllByProjektorAndSprawna(projektorRepository.getOne(projektorId),sprawna);
    }

    public List <Lampa> findAll(){return lampaRepository.findAll();}

    @Transactional
    public void addLampa(Lampa lampa){lampaRepository.save(lampa);}

    public void deleteLampa(Lampa lampa){
        lampaRepository.delete(lampa);
    }

}
