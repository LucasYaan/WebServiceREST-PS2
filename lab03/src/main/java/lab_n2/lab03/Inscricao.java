package lab_n2.lab03;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
/* @NoArgsConstructor
@AllArgsConstructor */
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // verificar isso
    private Long id;

    private Date dataInscricao;
    private String status;
    private String mensagemApresentacao;

    @ManyToOne
    private Estudante estudante;

    @ManyToOne
    private VagaEstagio vagaEstagio;
}