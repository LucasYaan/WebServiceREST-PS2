package lab_n2.lab03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstudanteController {
    @Autowired
    private EstudanteRepo estudanteRepo;

    @GetMapping("/mackenzie/estudantes")
    public Iterable<Estudante> getEstudantes(){
        return estudanteRepo.findAll();
    }

    @GetMapping("/mackenzie/estudantes/{id}")
    public Estudante getEstudante(@PathVariable long id){
        return estudanteRepo.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    @PostMapping("/mackenzie/estudantes")
    public Estudante createEstudante(@RequestBody Estudante e){
        return estudanteRepo.save(e);
    }

    @SuppressWarnings("null")
    @DeleteMapping("/mackenzie/estudantes/{id}")
    public boolean deleteEstudante(@PathVariable long id) {
        return estudanteRepo.findById(id).map(estudante -> {
            estudanteRepo.delete(estudante);
            return true;
        }).orElse(false);
    }

    @PutMapping("/mackenzie/estudantes/{id}")
    public boolean updateEstudante(@PathVariable long id, @RequestBody Estudante estudante) {
        return estudanteRepo.findById(id).map(e -> {
            e.setNome(estudante.getNome());
            e.setEmail(estudante.getEmail());
            estudanteRepo.save(e);
            return true;
        }).orElse(false);
    }    

    @SuppressWarnings("null")
    @PutMapping("/mackenzie/estudantes/{id}/areas")
    public boolean addAreaToEstudante(@PathVariable long id, @RequestBody Area area) {
        return estudanteRepo.findById(id).map(estudante -> {
            estudanteRepo.save(estudante);
            return true;
        }).orElse(false); 
    }

    @SuppressWarnings("null")
    @PutMapping("/mackenzie/estudantes/{id}/inscricoes")
    public boolean addInscricaoToEstudante(@PathVariable long id, @RequestBody Inscricao inscricao) {
        return estudanteRepo.findById(id).map(estudante -> {
            inscricao.setEstudante(estudante);
            estudanteRepo.save(estudante);
            return true;
        }).orElse(false);
    }
}