package DUR.databaseapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "ekran")
public class Ekran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ekranId;

    @NotNull
    private String model;
    private String wymiary;
    private String sterowanie;
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "salaId", nullable = false, updatable = false, insertable = true)
    private Sala sala;

    public Ekran() {
    }

    public Ekran(String model, String wymiary, String sterowanie, String opis) {
        this.model = model;
        this.wymiary = wymiary;
        this.sterowanie = sterowanie;
        this.opis = opis;
    }

    public int getEkranId() {
        return ekranId;
    }

    public void setEkranId(int ekranId) {
        this.ekranId = ekranId;
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

    public String getSterowanie() {
        return sterowanie;
    }

    public void setSterowanie(String sterowanie) {
        this.sterowanie = sterowanie;
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
        return "Ekran{" +
                "ekranId=" + ekranId +
                ", model='" + model + '\'' +
                ", wymiary='" + wymiary + '\'' +
                ", sterowanie='" + sterowanie + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
