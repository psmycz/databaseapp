package DUR.databaseapp.service;

import DUR.databaseapp.model.Przylacze;
import DUR.databaseapp.repository.PrzylaczeRepository;
import DUR.databaseapp.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PrzylaczeService {


    @Autowired
    private PrzylaczeRepository przylaczeRepository;

    @Autowired
    private SalaRepository salaRepository;

    public Przylacze findById(int id){return przylaczeRepository.getOne(id);}

    public List <Przylacze> findAll() {return przylaczeRepository.findAll();}

    public List <Przylacze> findAllByNazwa(String nazwa){return przylaczeRepository.findAllByNazwa(nazwa);};

    public List <Przylacze> findAllBySalaId(int salaId){return przylaczeRepository.findAllBySala(salaRepository.getOne(salaId));}

    @Transactional
    public void addPrzylacze(Przylacze przylacze) {
        przylaczeRepository.save(przylacze);
    }

    public void deletePrzylacze(Przylacze przylacze){
        przylaczeRepository.delete(przylacze);
    }
}
