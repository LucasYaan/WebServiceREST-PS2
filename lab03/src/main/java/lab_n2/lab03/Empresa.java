import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // verificar isso
    private Long id;

    private String nomeFantasia;
    private String cnpj;
    private String emailContato;
    private String endereco;
    private String descricao;

    @OneToMany(mappedBy = "empresa")  // verificar isso
    private List<VagaEstagio> vagas;
}