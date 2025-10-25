import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class VagaEstagio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // verificar isso
    private Long id;

    private String titulo;
    private String descricao;
    private Date dataPublicacao;
    private Boolean ativo;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Area area;

    @OneToMany(mappedBy = "vagaEstagio") // verificar isso
    private List<Inscricao> inscricoes;
}