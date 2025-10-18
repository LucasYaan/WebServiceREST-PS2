package lab_n2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class VagaController {
    @Autowired
    private VagaRepo VagaRepo;

    @GetMapping("/mackenzie/Vagas")
    public Iterable<Vaga> getVagas(){
        return VagaRepo.findAll();
    }

    @GetMapping("/mackenzie/Vagas/{id}")
    public Vaga getVaga(@PathVariable long id){
        return VagaRepo.findById(id).orElse(null);
    }

    @PostMapping("/mackenzie/Vagas")
    public Vaga createVaga(@RequestBody Vaga v){
        return VagaRepo.save(v);
    }

    @DeleteMapping("/mackenzie/Vagas/{id}")
    public boolean deleteVaga(@PathVariable long id) {
        return VagaRepo.findById(id).map(Vaga -> {
            VagaRepo.delete(Vaga);
            return true;
        }).orElse(false);
    }

    @PutMapping("/mackenzie/Vagas/{id}")
    public boolean updateVaga(@PathVariable long id, @RequestBody Vaga vaga) {
        return VagaRepo.findById(id).map(e -> {
            e.setTitulo(vaga.getTitulo());
            e.setDescricao(vaga.getDescricao());
            e.setPublicacao(vaga.getPublicacao());
            e.setAtivo(vaga.isAtivo());
            e.setIdEmpresa(vaga.getIdEmpresa());
            VagaRepo.save(e);
            return true;
        }).orElse(false);
    }    
}