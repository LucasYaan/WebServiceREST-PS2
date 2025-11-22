package lab_n2.lab03.model;

import jakarta.persistence.*;

@Entity
public class VagaArea {
    @Id @GeneratedValue
    private long id;

    @ManyToOne
    private VagaEstagio vaga;

    @ManyToOne
    private Area area;
}