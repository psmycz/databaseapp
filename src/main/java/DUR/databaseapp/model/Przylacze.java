package DUR.databaseapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "przylacze")
public class Przylacze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int przylaczeId;

    @NotNull
    private String nazwa;
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "salaId", nullable = false, updatable = false, insertable = true)
    private Sala sala;

    public Przylacze() {
    }

    public Przylacze(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public int getPrzylaczeId() {
        return przylaczeId;
    }

    public void setPrzylaczeId(int przylaczeId) {
        this.przylaczeId = przylaczeId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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

    @Override
    public String toString() {
        return "Przylacze{" +
                "przylaczeId=" + przylaczeId +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
