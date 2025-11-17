package lab_n2.lab03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaEstudanteService {
    @Autowired
    private EstudanteRepo estudanteRepo;
    @Autowired
    private AreaRepo areaRepo;
    @Autowired
    private AreaEstudanteRepo areaEstudanteRepo;

    public AreaEstudante associarAreaEstudante(Long estudanteId, Long areaId) {

        Estudante estudante = estudanteRepo.findById(estudanteId)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado"));

        Area area = areaRepo.findById(areaId)
                .orElseThrow(() -> new RuntimeException("Área não encontrada"));

        AreaEstudante relacao = new AreaEstudante();
        relacao.setArea(area);
        relacao.setEstudante(estudante);

        return areaEstudanteRepo.save(relacao);
    }

    public List<AreaEstudante> findByEstudanteId(long estudanteId) {
        return areaEstudanteRepo.findByEstudanteId(estudanteId);
    }

    public List<AreaEstudante> findByAreaId(long areaId) {
        return areaEstudanteRepo.findByAreaId(areaId);
    }

    public boolean deletarAssociacao(Long id) {
        if (areaEstudanteRepo.existsById(id)) {
            areaEstudanteRepo.deleteById(id);
            return true;
        }
        return false;
    }
}