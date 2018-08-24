package DUR.databaseapp.service;

import DUR.databaseapp.model.Wyposazenie;
import DUR.databaseapp.repository.SalaRepository;
import DUR.databaseapp.repository.WyposazenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WyposazenieService {

    @Autowired
    private WyposazenieRepository wyposazenieRepository;

    @Autowired
    private SalaRepository salaRepository;

    public Wyposazenie findById(int id){return wyposazenieRepository.getOne(id);}

    public List <Wyposazenie> findAll(){return wyposazenieRepository.findAll();}

    public Wyposazenie findBySalaId(int salaId){return wyposazenieRepository.findBySala(salaRepository.getOne(salaId));}

    @Transactional
    public void addWyposazenie(Wyposazenie wyposazenie){
        wyposazenieRepository.save(wyposazenie);
    }

    public void deleteWyposazenia(Wyposazenie wyposazenie){
        wyposazenieRepository.delete(wyposazenie);
    }
}
