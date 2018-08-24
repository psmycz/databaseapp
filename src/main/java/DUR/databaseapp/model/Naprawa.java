package DUR.databaseapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "naprawa")
public class Naprawa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int naprawaId;

    @NotNull
    private Date dataNaprawy;
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "salaId", nullable = false, updatable = false, insertable = true)
    private Sala sala;

    public Naprawa() {
    }

    public Naprawa(Date dataNaprawy, String opis) {
        this.dataNaprawy = dataNaprawy;
        this.opis = opis;
    }

    public int getNaprawaId() {
        return naprawaId;
    }

    public void setNaprawaId(int naprawaId) {
        this.naprawaId = naprawaId;
    }

    public Date getDataNaprawy() {
        return dataNaprawy;
    }

    public void setDataNaprawy(Date dataNaprawy) {
        this.dataNaprawy = dataNaprawy;
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
        return "Naprawa{" +
                "naprawaId=" + naprawaId +
                ", dataNaprawy=" + dataNaprawy +
                ", opis='" + opis + '\'' +
                '}';
    }
}
