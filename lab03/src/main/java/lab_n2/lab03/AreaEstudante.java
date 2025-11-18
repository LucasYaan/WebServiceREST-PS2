package lab_n2.lab03;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AreaEstudante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Area area;

    @ManyToOne
    private Estudante estudante;
}
