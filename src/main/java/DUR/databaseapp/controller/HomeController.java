package DUR.databaseapp.controller;

import DUR.databaseapp.model.*;
import DUR.databaseapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    SalaService salaService;
    @Autowired
    AudioService audioService;
    @Autowired
    AutomatykaService automatykaService;
    @Autowired
    EkranService ekranService;
    @Autowired
    LampaService lampaService;

    @Autowired
    NaprawaService naprawaService;
    @Autowired
    ProjektorService projektorService;
    @Autowired
    PrzylaczeService przylaczeService;
    @Autowired
    TablicaService tablicaService;
    @Autowired
    VisualizerService visualizerService;
    @Autowired
    WyposazenieService wyposazenieService;
    @Autowired
    ZlaczeService zlaczeService;

    @GetMapping(value = "/")
    public ModelAndView home(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        List<Sala> salaList = salaService.findAll();
        List<Audio> audioList = audioService.findAll();
        modelAndView.addObject("salaList", salaList);
        modelAndView.addObject("audioList", audioList);
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @PostMapping(value = "/")
    public ModelAndView przejdz(@Valid int salaId){
        return new ModelAndView("redirect:/sala/{salaId}","salaId",salaId);
    }

    @GetMapping(value="/sala/{salaId}")
    public ModelAndView showSala(@PathVariable int salaId) {
        ModelAndView modelAndView = new ModelAndView();
        Sala sala = salaService.findById(salaId);
        List<Audio> audioList = audioService.findAllBySalaId(salaId);
        List<Automatyka> automatykaList = automatykaService.findAllBySalaId(salaId);
        List<Ekran> ekranList = ekranService.findAllBySalaId(salaId);
        List<Naprawa> naprawaList = naprawaService.findAllBySalaId(salaId);
        List<Projektor> projektorList = projektorService.findAllBySalaId(salaId);
        List<Przylacze> przylaczeList = przylaczeService.findAllBySalaId(salaId);
        List<Tablica> tablicaList = tablicaService.findAllBySalaId(salaId);
        List<Visualizer> visualizerList = visualizerService.findAllBySalaId(salaId);
        List<Zlacze> zlaczeList = zlaczeService.findAllBySalaId(salaId);
        Wyposazenie wyposazenie = wyposazenieService.findBySalaId(salaId);
        modelAndView.addObject("audioList", audioList);
        modelAndView.addObject("automatykaList",automatykaList);
        modelAndView.addObject("ekranList",ekranList);
        modelAndView.addObject("naprawaList",naprawaList);
        modelAndView.addObject("projektorList",projektorList);
        modelAndView.addObject("przylaczeList",przylaczeList);
        modelAndView.addObject("tablicaList",tablicaList);
        modelAndView.addObject("visualizerList",visualizerList);
        modelAndView.addObject("zlaczeList",zlaczeList);
        modelAndView.addObject("wyposazenie",wyposazenie);
        modelAndView.addObject("sala", sala);
        modelAndView.setViewName("sala");

        return modelAndView;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////            CRUD AUDIO           ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/sala/{salaId}/audioAdd")
    public ModelAndView addAudio(@PathVariable int salaId){
        ModelAndView modelAndView = new ModelAndView();
        Audio audio = new Audio();
        modelAndView.addObject("audio",audio);
        modelAndView.setViewName("audioAdd");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/audioAdd")
    public ModelAndView saveAudio(@Valid Audio audio, @PathVariable int salaId){
        audio.setSala(salaService.findById(salaId));
        audioService.addAudio(audio);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/audioModify/{audioId}")
    public ModelAndView modifyAudio(@PathVariable int salaId,@PathVariable("audioId") Audio audio){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("audio",audio);
        modelAndView.setViewName("audioModify");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/audioModify")
    public ModelAndView updateAudio(@PathVariable int salaId,Audio audio){
        audioService.addAudio(audio); // wyjebalem anotacje i jak znalazl dziala pieknie, post mapping tez normalny teraz a nie jakies {id} cos
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/audioDelete/{audioId}")
    public ModelAndView deleteAudio(@PathVariable int salaId, @PathVariable("audioId") Audio audio) {
        audioService.deleteAudio(audio);
        return new ModelAndView("redirect:/sala/{salaId}");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////         CRUD AUTOMATYKA         ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/sala/{salaId}/automatykaAdd")
    public ModelAndView addAutomatyka(@PathVariable int salaId){
        ModelAndView modelAndView = new ModelAndView();
        Automatyka automatyka = new Automatyka();
        modelAndView.addObject("automatyka",automatyka);
        modelAndView.setViewName("automatykaAdd");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/automatykaAdd")
    public ModelAndView saveAutomatyka(@Valid Automatyka automatyka, @PathVariable int salaId){
        automatyka.setSala(salaService.findById(salaId));
        automatykaService.addAutomatyka(automatyka);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/automatykaModify/{automatykaId}")
    public ModelAndView modifyAutomatyka(@PathVariable int salaId,@PathVariable("automatykaId") Automatyka automatyka){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("automatyka",automatyka);
        modelAndView.setViewName("automatykaModify");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/automatykaModify")
    public ModelAndView updateAutomatyka(@PathVariable int salaId,Automatyka automatyka){
        automatykaService.addAutomatyka(automatyka);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/automatykaDelete/{automatykaId}")
    public ModelAndView deleteAutomatyka(@PathVariable int salaId, @PathVariable("automatykaId") Automatyka automatyka) {
        automatykaService.deleteAutomatyka(automatyka);
        return new ModelAndView("redirect:/sala/{salaId}");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////          CRUD EKRAN             ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/sala/{salaId}/ekranAdd")
    public ModelAndView addEkran(@PathVariable int salaId){
        ModelAndView modelAndView = new ModelAndView();
        Ekran ekran = new Ekran();
        modelAndView.addObject("ekran",ekran);
        modelAndView.setViewName("ekranAdd");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/ekranAdd")
    public ModelAndView saveEkran(@Valid Ekran ekran, @PathVariable int salaId){
        ekran.setSala(salaService.findById(salaId));
        ekranService.addEkran(ekran);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/ekranModify/{ekranId}")
    public ModelAndView modifyEkran(@PathVariable int salaId,@PathVariable("ekranId") Ekran ekran){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ekran",ekran);
        modelAndView.setViewName("ekranModify");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/ekranModify")
    public ModelAndView updateEkran(@PathVariable int salaId,Ekran ekran){
        ekranService.addEkran(ekran);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/ekranDelete/{ekranId}")
    public ModelAndView deleteEkran(@PathVariable int salaId, @PathVariable("ekranId") Ekran ekran) {
        ekranService.deleteEkran(ekran);
        return new ModelAndView("redirect:/sala/{salaId}");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////          CRUD NAPRAWA           ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/sala/{salaId}/naprawaAdd")
    public ModelAndView addNaprawa(@PathVariable int salaId){
        ModelAndView modelAndView = new ModelAndView();
        Naprawa naprawa = new Naprawa();
        modelAndView.addObject("naprawa",naprawa);
        modelAndView.setViewName("naprawaAdd");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/naprawaAdd")
    public ModelAndView saveNaprawa(@Valid Naprawa naprawa, @PathVariable int salaId){
        naprawa.setSala(salaService.findById(salaId));
        naprawaService.addNaprawa(naprawa);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/naprawaModify/{naprawaId}")
    public ModelAndView modifyNaprawa(@PathVariable int salaId,@PathVariable("naprawaId") Naprawa naprawa){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("naprawa",naprawa);
        modelAndView.setViewName("naprawaModify");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/naprawaModify")
    public ModelAndView updateNaprawa(@PathVariable int salaId,Naprawa naprawa){
        naprawaService.addNaprawa(naprawa);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/naprawaDelete/{naprawaId}")
    public ModelAndView deleteNaprawa(@PathVariable int salaId, @PathVariable("naprawaId") Naprawa naprawa) {
        naprawaService.deleteNaprawa(naprawa);
        return new ModelAndView("redirect:/sala/{salaId}");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////         CRUD PROJEKTOR          ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/sala/{salaId}/projektorAdd")
    public ModelAndView addProjektor(@PathVariable int salaId){
        ModelAndView modelAndView = new ModelAndView();
        Projektor projektor = new Projektor();
        modelAndView.addObject("projektor",projektor);
        modelAndView.setViewName("projektorAdd");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/projektorAdd")
    public ModelAndView saveProjektor(@Valid Projektor projektor, @PathVariable int salaId){
        projektor.setSala(salaService.findById(salaId));
        projektorService.addProjektor(projektor);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/projektorModify/{projektorId}")
    public ModelAndView modifyProjektor(@PathVariable int salaId,@PathVariable("projektorId") Projektor projektor){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("projektor",projektor);
        modelAndView.setViewName("projektorModify");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/projektorModify")
    public ModelAndView updateProjektor(@PathVariable int salaId,Projektor projektor){
        projektorService.addProjektor(projektor);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/projektorDelete/{projektorId}")
    public ModelAndView deleteProjektor(@PathVariable int salaId, @PathVariable("projektorId") Projektor projektor) {
        projektorService.deleteProjektor(projektor);
        return new ModelAndView("redirect:/sala/{salaId}");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////         CRUD PRZYLACZE          ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/sala/{salaId}/przylaczeAdd")
    public ModelAndView addPrzylacze(@PathVariable int salaId){
        ModelAndView modelAndView = new ModelAndView();
        Przylacze przylacze = new Przylacze();
        modelAndView.addObject("przylacze",przylacze);
        modelAndView.setViewName("przylaczeAdd");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/przylaczeAdd")
    public ModelAndView savePrzylacze(@Valid Przylacze przylacze, @PathVariable int salaId){
        przylacze.setSala(salaService.findById(salaId));
        przylaczeService.addPrzylacze(przylacze);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/przylaczeModify/{przylaczeId}")
    public ModelAndView modifyPrzylacze(@PathVariable int salaId,@PathVariable("przylaczeId") Przylacze przylacze){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("przylacze",przylacze);
        modelAndView.setViewName("przylaczeModify");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/przylaczeModify")
    public ModelAndView updatePrzylacze(@PathVariable int salaId,Przylacze przylacze){
        przylaczeService.addPrzylacze(przylacze);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/przylaczeDelete/{przylaczeId}")
    public ModelAndView deletePrzylacze(@PathVariable int salaId, @PathVariable("przylaczeId") Przylacze przylacze) {
        przylaczeService.deletePrzylacze(przylacze);
        return new ModelAndView("redirect:/sala/{salaId}");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////          CRUD TABLICA           ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/sala/{salaId}/tablicaAdd")
    public ModelAndView addTablica(@PathVariable int salaId){
        ModelAndView modelAndView = new ModelAndView();
        Tablica tablica = new Tablica();
        modelAndView.addObject("tablica",tablica);
        modelAndView.setViewName("tablicaAdd");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/tablicaAdd")
    public ModelAndView saveTablica(@Valid Tablica tablica, @PathVariable int salaId){
        tablica.setSala(salaService.findById(salaId));
        tablicaService.addTablica(tablica);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/tablicaModify/{tablicaId}")
    public ModelAndView modifyTablica(@PathVariable int salaId,@PathVariable("tablicaId") Tablica tablica){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tablica",tablica);
        modelAndView.setViewName("tablicaModify");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/tablicaModify")
    public ModelAndView updateTablica(@PathVariable int salaId,Tablica tablica){
        tablicaService.addTablica(tablica);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/tablicaDelete/{tablicaId}")
    public ModelAndView deleteTablica(@PathVariable int salaId, @PathVariable("tablicaId") Tablica tablica) {
        tablicaService.deleteTablica(tablica);
        return new ModelAndView("redirect:/sala/{salaId}");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////         CRUD VISUALIZER         ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/sala/{salaId}/visualizerAdd")
    public ModelAndView addVisualizer(@PathVariable int salaId){
        ModelAndView modelAndView = new ModelAndView();
        Visualizer visualizer = new Visualizer();
        modelAndView.addObject("visualizer",visualizer);
        modelAndView.setViewName("visualizerAdd");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/visualizerAdd")
    public ModelAndView saveVisualizer(@Valid Visualizer visualizer, @PathVariable int salaId){
        visualizer.setSala(salaService.findById(salaId));
        visualizerService.addVisualizer(visualizer);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/visualizerModify/{visualizerId}")
    public ModelAndView modifyVisualizer(@PathVariable int salaId,@PathVariable("visualizerId") Visualizer visualizer){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("visualizer",visualizer);
        modelAndView.setViewName("visualizerModify");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/visualizerModify")
    public ModelAndView updateVisualizer(@PathVariable int salaId, Visualizer visualizer){
        visualizerService.addVisualizer(visualizer);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/visualizerDelete/{visualizerId}")
    public ModelAndView deleteVisualizer(@PathVariable int salaId, @PathVariable("visualizerId") Visualizer visualizer) {
        visualizerService.deleteVisualizer(visualizer);
        return new ModelAndView("redirect:/sala/{salaId}");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////         CRUD WYPOSAZENIE        ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/sala/{salaId}/wyposazenieAdd")
    public ModelAndView addWyposazenie(@PathVariable int salaId){
        ModelAndView modelAndView = new ModelAndView();
        Wyposazenie wyposazenie = new Wyposazenie();
        modelAndView.addObject("wyposazenie",wyposazenie);
        modelAndView.setViewName("wyposazenieAdd");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/wyposazenieAdd")
    public ModelAndView saveWyposazenie(@Valid Wyposazenie wyposazenie, @PathVariable int salaId){
        wyposazenie.setSala(salaService.findById(salaId));
        wyposazenieService.addWyposazenie(wyposazenie);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/wyposazenieModify/{wyposazenieId}")
    public ModelAndView modifyWyposazenie(@PathVariable int salaId,@PathVariable("wyposazenieId") Wyposazenie wyposazenie){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("wyposazenie",wyposazenie);
        modelAndView.setViewName("wyposazenieModify");
        return modelAndView;
    }

    @PostMapping(value = "/sala/{salaId}/wyposazenieModify")
    public ModelAndView updateWyposazenie(@PathVariable int salaId,Wyposazenie wyposazenie){
        wyposazenieService.addWyposazenie(wyposazenie);
        ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
        return modelAndView;
    }

    @GetMapping(value = "/sala/{salaId}/wyposazenieDelete/{wyposazenieId}")
    public ModelAndView deleteWyposazenie(@PathVariable int salaId, @PathVariable("wyposazenieId") Wyposazenie wyposazenie) {
        wyposazenieService.deleteWyposazenia(wyposazenie);
        return new ModelAndView("redirect:/sala/{salaId}");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////          CRUD ZLACZE            ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

        @GetMapping(value = "/sala/{salaId}/zlaczeAdd")
        public ModelAndView addZlacze(@PathVariable int salaId){
            ModelAndView modelAndView = new ModelAndView();
            Zlacze zlacze = new Zlacze();
            modelAndView.addObject("zlacze",zlacze);
            modelAndView.setViewName("zlaczeAdd");
            return modelAndView;
        }

        @PostMapping(value = "/sala/{salaId}/zlaczeAdd")
        public ModelAndView saveZlacze(@Valid Zlacze zlacze, @PathVariable int salaId){
            zlacze.setSala(salaService.findById(salaId));
            zlaczeService.addZlacze(zlacze);
            ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
            return modelAndView;
        }

        @GetMapping(value = "/sala/{salaId}/zlaczeModify/{zlaczeId}")
        public ModelAndView modifyZlacze(@PathVariable int salaId,@PathVariable("zlaczeId") Zlacze zlacze){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("zlacze",zlacze);
            modelAndView.setViewName("zlaczeModify");
            return modelAndView;
        }

        @PostMapping(value = "/sala/{salaId}/zlaczeModify")
        public ModelAndView updateZlacze(@PathVariable int salaId, Zlacze zlacze){
            zlaczeService.addZlacze(zlacze);
            ModelAndView modelAndView = new ModelAndView("redirect:/sala/{salaId}");
            return modelAndView;
        }

        @GetMapping(value = "/sala/{salaId}/zlaczeDelete/{zlaczeId}")
        public ModelAndView deleteZlacze(@PathVariable int salaId, @PathVariable("zlaczeId") Zlacze zlacze) {
            zlaczeService.deleteZlacze(zlacze);
            return new ModelAndView("redirect:/sala/{salaId}");
        }

}
