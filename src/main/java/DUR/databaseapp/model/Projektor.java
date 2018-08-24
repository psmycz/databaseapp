package DUR.databaseapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "projektor")
public class Projektor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projektorId;

    @NotNull
    private String model;
    @NotNull
    private String numerSeryjny;
    private String adresIp;
    private String adresMac;
    private String wersjaOprogr;
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "salaId", nullable = false, updatable = false, insertable = true)
    private Sala sala;

    @OneToMany(mappedBy = "projektor",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<Lampa> lampaList;

    // dodatkowa funkcja

    public void addLampa(Lampa lampa) {
        if (lampaList == null) {
            lampaList = new ArrayList<>();
        }
        lampaList.add(lampa);
        lampa.setProjektor(this);
    }

    // konstruktory

    public Projektor() {
    }

    public Projektor(String model, String numerSeryjny, String adresIp, String adresMac, String wersjaOprogr, String opis) {
        this.model = model;
        this.numerSeryjny = numerSeryjny;
        this.adresIp = adresIp;
        this.adresMac = adresMac;
        this.wersjaOprogr = wersjaOprogr;
        this.opis = opis;
    }

    // getter & setter

    public int getProjektorId() {
        return projektorId;
    }

    public void setProjektorId(int projektorId) {
        this.projektorId = projektorId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumerSeryjny() {
        return numerSeryjny;
    }

    public void setNumerSeryjny(String numerSeryjny) {
        this.numerSeryjny = numerSeryjny;
    }

    public String getAdresIp() {
        return adresIp;
    }

    public void setAdresIp(String adresIp) {
        this.adresIp = adresIp;
    }

    public String getAdresMac() {
        return adresMac;
    }

    public void setAdresMac(String adresMac) {
        this.adresMac = adresMac;
    }

    public String getWersjaOprogr() {
        return wersjaOprogr;
    }

    public void setWersjaOprogr(String wersjaOprogr) {
        this.wersjaOprogr = wersjaOprogr;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Lampa> getLampaList() {
        return lampaList;
    }

    public void setLampaList(List<Lampa> lampaList) {
        this.lampaList = lampaList;
    }

    @Override
    public String toString() {
        return "Projektor{" +
                "projektorId=" + projektorId +
                ", model='" + model + '\'' +
                ", numerSeryjny='" + numerSeryjny + '\'' +
                ", adresIp='" + adresIp + '\'' +
                ", adresMac='" + adresMac + '\'' +
                ", wersjaOprogr='" + wersjaOprogr + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
