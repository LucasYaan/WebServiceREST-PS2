package lab_n2.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class EstudanteController {
    private List<Estudante> estudantes;
    public EstudanteController() {
        estudantes = new ArrayList<>();
        estudantes.add(new Estudante(1,"Eduardo",1275,"SI"));
        estudantes.add(new Estudante(2,"Lucas",1272,"SI"));
        estudantes.add(new Estudante(3,"Daniel",1270,"ADM"));
    }

    @GetMapping("/mackenzie/alunos")
    public List<Estudante> getEstudantes(){
        return estudantes;
    }
    @GetMapping("/mackenzie/alunos/{id}")
    public Estudante getEstudante(@PathVariable long id){
        for(Estudante e:estudantes){
            if(id==e.getId()){
                return e;
            }
        }
        return null;
    }
    @PostMapping("/mackenzie/alunos")
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

    @DeleteMapping("/mackenzie/alunos/{id}")
    public boolean deleteEstudante(@PathVariable long id) {
        for(Estudante e:estudantes) {
            if(id==e.getId()){
                estudantes.remove(e);
                return true;
            }
        }
        return false;
    }

    @PutMapping("/mackenzie/alunos/{id}")
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