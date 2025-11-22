package lab_n2.lab03.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Data
@Entity
public class VagaEstagio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private Date dataPublicacao;
    private Boolean ativo;

    @ManyToOne
    private Empresa empresa;
}