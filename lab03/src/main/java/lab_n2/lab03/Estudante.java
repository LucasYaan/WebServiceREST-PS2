package lab_n2.lab03;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
}