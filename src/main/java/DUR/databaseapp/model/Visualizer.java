package DUR.databaseapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "visualizer")
public class Visualizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visualizerId;

    @NotNull
    private String model;
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "salaId", nullable = false, updatable = false, insertable = true)
    private Sala sala;

    public Visualizer() {
    }

    public Visualizer(String model, String opis) {
        this.model = model;
        this.opis = opis;
    }

    public int getVisualizerId() {
        return visualizerId;
    }

    public void setVisualizerId(int visualizerId) {
        this.visualizerId = visualizerId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
        return "Visualizer{" +
                "visualizerId=" + visualizerId +
                ", model='" + model + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }

}
