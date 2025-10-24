import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // verificar isso
    private Long id;
    
    private String nome;
    private String email;

    @ManyToMany
    private List<Area> areasInteresse = new ArrayList<>();

    @OneToMany(mappedBy = "estudante") // verificar isso
    private List<Inscricao> inscricoes = new ArrayList<>();
}