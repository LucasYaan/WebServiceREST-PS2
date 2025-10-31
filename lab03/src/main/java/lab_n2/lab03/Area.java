package lab_n2.lab03;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // verificar isso
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "areasInteresse")  // verificar isso
    private List<Estudante> estudantes;

    @ManyToMany
    private List<VagaEstagio> vagas;
}