package lab_n2.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class VagaController {
    private List<Vaga> vagas;

    public VagaController() {
        vagas = new ArrayList<>();
        vagas.add(new Vaga(1,"Dev Backend","Aos amantes de java","Spring Boot, Java, SQL"));
    }

    @GetMapping("/mackenzie/vagas")
    public List<Vaga> getvagas() {
        return vagas;
    }
    @GetMapping("/mackenzie/vagas/{id}")
    public Vaga getVaga(@PathVariable long id) {
        for(Vaga v : vagas) {
            if(id == v.getId()){
                return v;
            }
        }
        return null;
    }
    @PostMapping("/mackenzie/vagas")
    public Vaga create(@RequestBody Vaga vaga) {
        long maior = 0;
        for(Vaga v : vagas) {
            if (vaga.getId() > maior){
                maior = vaga.getId();
            }
        }
        vaga.setId(maior + 1);
        vagas.add(vaga);
        return vaga;
    }
}