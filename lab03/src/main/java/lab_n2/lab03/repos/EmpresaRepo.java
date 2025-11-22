package lab_n2.lab03.repos;

import org.springframework.data.repository.CrudRepository;

import lab_n2.lab03.model.Empresa;

public interface EmpresaRepo extends CrudRepository<Empresa, Long> {
    
}