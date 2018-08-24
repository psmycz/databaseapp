package DUR.databaseapp.service;


import DUR.databaseapp.model.Ekran;
import DUR.databaseapp.repository.EkranRepository;
import DUR.databaseapp.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EkranService {

    @Autowired
    private EkranRepository ekranRepository;

    @Autowired
    private SalaRepository salaRepository;

    public Ekran findById (int id){return ekranRepository.getOne(id);}

    public List <Ekran> findAll(){return ekranRepository.findAll();}

    public List <Ekran> findAllByModel(String model){return ekranRepository.findAllByModel(model);}

    public List <Ekran> findAllBySalaId(int salaId){
        return ekranRepository.findAllBySala(salaRepository.getOne(salaId));
    }

    @Transactional
    public void addEkran (Ekran ekran){
        ekranRepository.save(ekran);
    }

    public void deleteEkran(Ekran ekran){
        ekranRepository.delete(ekran);
    }
}
