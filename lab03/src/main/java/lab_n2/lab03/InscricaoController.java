package lab_n2.lab03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController 
public class InscricaoController {
    @Autowired
    private InscricaoRepo inscricaoRepo;

    @GetMapping("/mackenzie/inscricoes")
    public Iterable<Inscricao> getInscricoes(){
        return inscricaoRepo.findAll();
    }

    @GetMapping("/mackenzie/inscricoes/{id}")
    public Inscricao getInscricao(@PathVariable long id){
        return inscricaoRepo.findById(id).orElse(null);
    }

    @PostMapping("/mackenzie/inscricoes")
    public Inscricao createInscricao(@RequestBody Inscricao e){
        return inscricaoRepo.save(e);
    }

    @DeleteMapping("/mackenzie/inscricoes/{id}")
    public boolean deleteInscricao(@PathVariable long id) {
        return inscricaoRepo.findById(id).map(inscricao -> {
            inscricaoRepo.delete(inscricao);
            return true;
        }).orElse(false);
    }

    @PutMapping("/mackenzie/inscricoes/{id}")
    public boolean updateInscricao(@PathVariable long id, @RequestBody Inscricao inscricao) {
        return inscricaoRepo.findById(id).map(i -> {
            i.setDataInscricao(inscricao.getDataInscricao());
            i.setStatus(inscricao.getStatus());
            i.setMensagemApresentacao(inscricao.getMensagemApresentacao());
            inscricaoRepo.save(i);
            return true;
        }).orElse(false);
    }
}