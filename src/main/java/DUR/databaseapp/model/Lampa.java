package DUR.databaseapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "lampa")
public class Lampa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lampaId;

    @NotNull
    private int czasPracy;
    @NotNull
    private Date dataKontroli;
    @NotNull
    private boolean sprawna;
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "projektorId", nullable = false, updatable = false, insertable = true)
    private Projektor projektor;

    public Lampa() {
    }

    public Lampa(Date dataKontroli, boolean sprawna, String opis) {
        this.dataKontroli = dataKontroli;
        this.sprawna = sprawna;
        this.opis = opis;
    }

    public int getLampaId() {
        return lampaId;
    }

    public void setLampaId(int lampaId) {
        this.lampaId = lampaId;
    }

    public int getCzasPracy() {
        return czasPracy;
    }

    public void setCzasPracy(int czasPracy) {
        this.czasPracy = czasPracy;
    }

    public Date getDataKontroli() {
        return dataKontroli;
    }

    public void setDataKontroli(Date dataKontroli) {
        this.dataKontroli = dataKontroli;
    }

    public boolean isSprawna() {
        return sprawna;
    }

    public void setSprawna(boolean sprawna) {
        this.sprawna = sprawna;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Projektor getProjektor() {
        return projektor;
    }

    public void setProjektor(Projektor projektor) {
        this.projektor = projektor;
    }

    @Override
    public String toString() {
        return "Lampa{" +
                "lampaId=" + lampaId +
                ", czasPracy=" + czasPracy +
                ", dataKontroli=" + dataKontroli +
                ", sprawna=" + sprawna +
                ", opis='" + opis + '\'' +
                '}';
    }
}
