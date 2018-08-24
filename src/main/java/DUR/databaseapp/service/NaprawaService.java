package DUR.databaseapp.service;

import DUR.databaseapp.model.Naprawa;
import DUR.databaseapp.repository.NaprawaRepository;
import DUR.databaseapp.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class NaprawaService {

    @Autowired
    private NaprawaRepository naprawaRepository;

    @Autowired
    private SalaRepository salaRepository;

    public Naprawa findById (int id){return naprawaRepository.getOne(id);}

    public List <Naprawa> findAll(){return naprawaRepository.findAll();}

    public List <Naprawa> findAllBySalaId (int salaId){
        return naprawaRepository.findAllBySala(salaRepository.getOne(salaId));
    }

    public List <Naprawa> findAllByDataNaprawyGreaterThan(Date dataNaprawy){return naprawaRepository.findAllByDataNaprawyGreaterThan(dataNaprawy);}

    public List <Naprawa> findAllByDataNaprawyLessThan(Date dataNaprawy){return naprawaRepository.findAllByDataNaprawyLessThan(dataNaprawy);}


    @Transactional
    public void addNaprawa (Naprawa naprawa){ naprawaRepository.save(naprawa);}

    public void deleteNaprawa(Naprawa naprawa){
        naprawaRepository.delete(naprawa);
    }
}
