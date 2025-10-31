package lab_n2.lab03;

import lombok.Data;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;

    @ManyToMany
    private List<Area> areasInteresse = new ArrayList<>();

    @OneToMany(mappedBy = "estudante")
    private List<Inscricao> inscricoes = new ArrayList<>();
}