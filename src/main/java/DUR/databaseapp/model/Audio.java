package DUR.databaseapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "audio")
public class Audio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int audioId;

    @NotNull
    private String typ;
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "salaId", nullable = false, updatable = false, insertable = true)
    private Sala sala;

    public Audio() {
    }

    public Audio(String typ, String opis) {
        super();
        this.typ = typ;
        this.opis = opis;
    }


    public int getAudioId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId = audioId;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
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
        return "Audio{" +
                "audioId=" + audioId +
                ", typ='" + typ + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }

}
