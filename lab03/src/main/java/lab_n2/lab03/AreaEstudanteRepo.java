package lab_n2.lab03;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AreaEstudanteRepo extends CrudRepository<AreaEstudante, Long> {
    List<AreaEstudante> findByEstudanteId(long estudanteId);
    List<AreaEstudante> findByAreaId(long areaId);
}
