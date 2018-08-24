package DUR.databaseapp.service;

import DUR.databaseapp.model.Sala;
import DUR.databaseapp.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    SalaRepository salaRepository;

    public List<Sala> findAll(){
        return salaRepository.findAll();
    }

    public List<Sala> findAllByBudynek(String budynek){
        return salaRepository.findAllByBudynek(budynek);
    }

    public Sala findByBudynekAndNumer(String budynek, int numer){return salaRepository.findByBudynekAndNumer(budynek, numer);}

    public Sala findById(int salaId){
        return salaRepository.getOne(salaId);
    }

    @Transactional
    public void saveSala(Sala sala){
        salaRepository.save(sala);
    }

    public void deleteSala(Sala sala){
        salaRepository.delete(sala);
    }

}
