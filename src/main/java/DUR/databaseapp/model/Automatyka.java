package DUR.databaseapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "automatyka")
public class Automatyka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int automatykaId;

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

    public Automatyka() {
    }

    public Automatyka(String nazwa, String opis, Sala sala) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.sala = sala;
    }

    public int getAutomatykaId() {
        return automatykaId;
    }

    public void setAutomatykaId(int automatykaId) {
        this.automatykaId = automatykaId;
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
        return "Automatyka{" +
                "automatykaId=" + automatykaId +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
