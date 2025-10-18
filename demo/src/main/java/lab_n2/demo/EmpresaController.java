package lab_n2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmpresaController {
    @Autowired
    private EmpresaRepo empresaRepo;

    @GetMapping("/mackenzie/empresas")
    public Iterable<Empresa> getEmpresas(){
        return empresaRepo.findAll();
    }

    @GetMapping("/mackenzie/empresas/{id}")
    public Empresa getEmpresa(@PathVariable long id){
        return empresaRepo.findById(id).orElse(null);
    }

    @PostMapping("/mackenzie/empresas")
    public Empresa createEmpresa(@RequestBody Empresa e){
        return empresaRepo.save(e);
    }

    @DeleteMapping("/mackenzie/empresas/{id}")
    public boolean deleteEmpresa(@PathVariable long id) {
        return empresaRepo.findById(id).map(empresa -> {
            empresaRepo.delete(empresa);
            return true;
        }).orElse(false);
    }

    @PutMapping("/mackenzie/empresas/{id}")
    public boolean updateEmpresa(@PathVariable long id, @RequestBody Empresa empresa) {
        return empresaRepo.findById(id).map(e -> {
            e.setNome(empresa.getNome());
            e.setCnpj(empresa.getCnpj());
            e.setEmailContato(empresa.getEmailContato());
            empresaRepo.save(e);
            return true;
        }).orElse(false);
    }    
}