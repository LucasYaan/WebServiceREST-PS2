package lab_n2.lab03;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataInscricao;
    private String status;
    private String mensagemApresentacao;

    @ManyToOne
    private Estudante estudante;

    @ManyToOne
    private VagaEstagio vagaEstagio;
}