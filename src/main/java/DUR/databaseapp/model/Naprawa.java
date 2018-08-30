package DUR.databaseapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "naprawa")
public class Naprawa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int naprawaId;

    @NotNull
    @DateTimeFormat (pattern = "yyyy-mm-dd")
    private java.sql.Date dataNaprawy;
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
        this.dataNaprawy = (java.sql.Date) dataNaprawy;
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
        this.dataNaprawy = (java.sql.Date) dataNaprawy;
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
