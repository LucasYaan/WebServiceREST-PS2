package lab_n2.lab03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mackenzie/area-estudante")
public class AreaEstudanteController {
    @Autowired
    private AreaEstudanteService service;

    @GetMapping("/area/{areaId}")
    public List<AreaEstudante> porArea(@PathVariable Long areaId) {
        return service.findByAreaId(areaId);
    }

    @GetMapping("/estudante/{estudanteId}")
    public List<AreaEstudante> porEstudante(@PathVariable Long estudanteId) {
        return service.findByEstudanteId(estudanteId);
    }
    
    @PostMapping
    public AreaEstudante associarAreaEstudante(@RequestBody AreaEstudanteRequest request) {
        return service.associarAreaEstudante(request.getEstudanteId(), request.getAreaId());
    }

    @DeleteMapping("/{id}")
    public void deletarAssociacao(@PathVariable Long id) {
        service.deletarAssociacao(id);
    }
}
    