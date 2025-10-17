package lab_n2.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class EstudanteController {
    private List<Estudante> estudantes;
    public EstudanteController() {
        estudantes = new ArrayList<>();
        estudantes.add(new Estudante(1,"Ana Paula Souza","ana.souza@email.com","2002-03-15", 2020));
        estudantes.add(new Estudante(2,"Carlos Henrique Lima","carlos.lima@email.com","2001-10-22", 2019));
        estudantes.add(new Estudante(3,"Fernanda Oliveira","fernanda.oliveira@email.com","2001-10-22", 2019));
        estudantes.add(new Estudante(4,"Lucas Pereira","lucas.pereira@email.com","2003-07-05", 2021));
        estudantes.add(new Estudante(5,"Gabriela Martins","gabriela.martins@email.com","2001-12-25", 2019));
        estudantes.add(new Estudante(6,"Rafael Costa","rafael.costa@email.com","2000-09-13", 2018));
        estudantes.add(new Estudante(7,"Juliana Silva","juliana.silva@email.com","2002-06-18", 2020));
        estudantes.add(new Estudante(8,"Marcos Vinícius","marcos.vinicius@email.com","2003-01-30", 2021));
        estudantes.add(new Estudante(9,"Camila Azevedo","camila.azevedo@email.com", "2001-11-08", 2019));
        estudantes.add(new Estudante(10,"Felipe Cardoso","felipe.cardoso@email.com","2000-08-27", 2020));
    }

    @GetMapping("/mackenzie/estudantes")
    public List<Estudante> getEstudantes(){
        return estudantes;
    }
    @GetMapping("/mackenzie/estudantes/{id}")
    public Estudante getEstudante(@PathVariable long id){
        for(Estudante e:estudantes){
            if(id==e.getId()){
                return e;
            }
        }
        return null;
    }
    @PostMapping("/mackenzie/estudantes")
    public Estudante create(@RequestBody Estudante e){
        long maior = 0;
        for(Estudante estudante: estudantes){
            if (estudante.getId() > maior){
                maior = estudante.getId();
            }
        }
        e.setId(maior + 1);
        estudantes.add(e);
        return e;
    }

    @DeleteMapping("/mackenzie/estudantes/{id}")
    public boolean deleteEstudante(@PathVariable long id) {
        for(Estudante e:estudantes) {
            if(id==e.getId()){
                estudantes.remove(e);
                return true;
            }
        }
        return false;
    }

    @PutMapping("/mackenzie/estudantes/{id}")
    public boolean updateEstudante(@PathVariable long id, @RequestBody Estudante estudante) {
        for(Estudante e:estudantes) {
            if(id==e.getId()){
                e.setNome(estudante.getNome());
                e.setCurso(estudante.getCurso());
                e.setMatricula(estudante.getMatricula());
                return true;
            }
        }
        return false;
    }
}