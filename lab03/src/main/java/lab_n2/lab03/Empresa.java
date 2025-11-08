package lab_n2.lab03;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFantasia;
    private String cnpj;
    private String emailContato;
    private String endereco;
    private String descricao;
}