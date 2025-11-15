package lab_n2.lab03;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String nome;

    @ManyToMany
    private List<Estudante> estudantes;
}