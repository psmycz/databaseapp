package DUR.databaseapp.service;

import DUR.databaseapp.model.Audio;
import DUR.databaseapp.repository.AudioRepository;
import DUR.databaseapp.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AudioService {

    @Autowired
    private AudioRepository audioRepository;
    @Autowired
    private SalaRepository salaRepository;

    public Audio findById(int id){
        return audioRepository.getOne(id);
    }

    public List <Audio> findAllByTyp(String Typ){
        return audioRepository.findAllByTyp(Typ);
    }

    public List <Audio> findAll(){
        return audioRepository.findAll();
    }

    public List <Audio> findAllBySalaId(int salaId){
        return audioRepository.findAllBySala(salaRepository.getOne(salaId));
    }

    @Transactional
    public void addAudio(Audio audio) {
        audioRepository.save(audio);
    }

    public void deleteAudio(Audio audio){
        audioRepository.delete(audio);
    }

}
