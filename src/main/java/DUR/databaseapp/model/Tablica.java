package DUR.databaseapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "tablica")
public class Tablica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tablicaId;

    @NotNull
    private String model;
    private String wymiary;
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "salaId", nullable = false, updatable = false, insertable = true)
    private Sala sala;

    public Tablica() {
    }

    public Tablica(String model, String wymiary, String opis) {
        this.model = model;
        this.wymiary = wymiary;
        this.opis = opis;
    }

    public int getTablicaId() {
        return tablicaId;
    }

    public void setTablicaId(int tablicaId) {
        this.tablicaId = tablicaId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWymiary() {
        return wymiary;
    }

    public void setWymiary(String wymiary) {
        this.wymiary = wymiary;
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
        return "Tablica{" +
                "tablicaId=" + tablicaId +
                ", model='" + model + '\'' +
                ", wymiary='" + wymiary + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
