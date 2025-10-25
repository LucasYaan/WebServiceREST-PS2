import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class VagaController {
    @Autowired
    private VagaEstagioRepo VagaRepo;

    @GetMapping("/mackenzie/Vagas")
    public Iterable<VagaEstagio> getVagas(){
        return VagaRepo.findAll();
    }

    @GetMapping("/mackenzie/Vagas/{id}")
    public VagaEstagio getVaga(@PathVariable long id){
        return VagaRepo.findById(id).orElse(null);
    }

    @PostMapping("/mackenzie/Vagas")
    public VagaEstagio createVaga(@RequestBody VagaEstagio v){
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
    public boolean updateVaga(@PathVariable long id, @RequestBody VagaEstagio vaga) {
        return VagaRepo.findById(id).map(e -> {
            e.setTitulo(vaga.getTitulo());
            e.setDescricao(vaga.getDescricao());
            e.setPublicacao(vaga.getPublicacao());
            e.setAtivo(vaga.isAtivo());
            e.setEmpresa(vaga.getEmpresa());
            e.setArea(vaga.getArea());
            VagaRepo.save(e);
            return true;
        }).orElse(false);
    }
    
    @PutMapping("/mackenzie/Vagas/{id}/inscricoes")
    public boolean addInscricaoToVaga(@PathVariable long id, @RequestBody Inscricao inscricao) {
        return VagaRepo.findById(id).map(vaga -> {
            inscricao.setVaga(vaga);
            vaga.getInscricoes().add(inscricao);
            VagaRepo.save(vaga);
            return true;
        }).orElse(false);
    }

    @PutMapping("/mackenzie/Vagas/{id}/areas")
    public boolean addAreaToVaga(@PathVariable long id, @RequestBody Area area) {
        return VagaRepo.findById(id).map(vaga -> {
            vaga.getAreas().add(area);  
            VagaRepo.save(vaga);
            return true;
        }).orElse(false);
    }
}