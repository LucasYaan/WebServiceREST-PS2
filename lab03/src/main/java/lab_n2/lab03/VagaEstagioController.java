package lab_n2.lab03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class VagaEstagioController {
    @Autowired
    private VagaEstagioRepo vagaRepo;

    @GetMapping("/mackenzie/vagas")
    public Iterable<VagaEstagio> getVagas(){
        return vagaRepo.findAll();
    }

    @GetMapping("/mackenzie/vagas/{id}")
    public VagaEstagio getVaga(@PathVariable long id){
        return vagaRepo.findById(id).orElse(null);
    }

    @PostMapping("/mackenzie/vagas")
    public VagaEstagio createVaga(@RequestBody VagaEstagio v){
        return vagaRepo.save(v);
    }

    @DeleteMapping("/mackenzie/vagas/{id}")
    public boolean deleteVaga(@PathVariable long id) {
        return vagaRepo.findById(id).map(vaga -> {
            vagaRepo.delete(vaga);
            return true;
        }).orElse(false);
    }

    @PutMapping("/mackenzie/vagas/{id}")
    public boolean updateVaga(@PathVariable long id, @RequestBody VagaEstagio vaga) {
        return vagaRepo.findById(id).map(e -> {
            e.setTitulo(vaga.getTitulo());
            e.setDescricao(vaga.getDescricao());
            e.setDataPublicacao(vaga.getDataPublicacao());
            e.setAtivo(vaga.getAtivo());
            vagaRepo.save(e);
            return true;
        }).orElse(false);
    }
    
    @PutMapping("/mackenzie/vagas/{id}/inscricoes")
    public boolean addInscricaoToVaga(@PathVariable long id, @RequestBody Inscricao inscricao) {
        return vagaRepo.findById(id).map(vaga -> {
            inscricao.setVagaEstagio(vaga);
            vaga.getInscricoes().add(inscricao);
            vagaRepo.save(vaga);
            return true;
        }).orElse(false);
    }

    @PutMapping("/mackenzie/vagas/{id}/areas")
    public boolean addAreaToVaga(@PathVariable long id, @RequestBody Area area) {
        return vagaRepo.findById(id).map(vaga -> {
            vaga.getAreas().add(area);
            vagaRepo.save(vaga);
            return true;
        }).orElse(false);
    }
}