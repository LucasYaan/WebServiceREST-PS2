package lab_n2.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmpresaController {
    private List<Empresa> empresas;
    public EmpresaController() {
        empresas = new ArrayList<>();
        empresas.add(new Empresa(1, "Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"));
        empresas.add(new Empresa(2, "Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com"));
        empresas.add(new Empresa(3, "Gamma Serviços S.A.", "11.222.333/0001-44", "servicos@gamma.com"));
        empresas.add(new Empresa(4, "Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com"));
        empresas.add(new Empresa(5, "Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com"));
    }

    @GetMapping("/mackenzie/empresas")
    public List<Empresa> getEmpresas(){
        return empresas;
    }

    @GetMapping("/mackenzie/empresas/{id}")
    public Empresa getEmpresa(@PathVariable long id){
        for(Empresa e:empresas){
            if(id==e.getId()){
                return e;
            }
        }
        return null;
    }

    @PostMapping("/mackenzie/empresas")
    public Empresa createEmpresa(@RequestBody Empresa e){
        long maior = 0;
        for(Empresa empresa: empresas){
            if (empresa.getId() > maior){
                maior = empresa.getId();
            }
        }
        e.setId(maior + 1);
        empresas.add(e);
        return e;
    }

    @DeleteMapping("/mackenzie/empresas/{id}")
    public boolean deleteEmpresa(@PathVariable long id) {
        for(Empresa e:empresas) {
            if(id==e.getId()){
                empresas.remove(e);
                return true;
            }
        }
        return false;
    }

    @PutMapping("/mackenzie/empresas/{id}")
    public boolean updateEmpresa(@PathVariable long id, @RequestBody Empresa empresa) {
        for(Empresa e:empresas) {
            if(id==e.getId()){
                e.setNome(empresa.getNome());
                e.setCnpj(empresa.getCnpj());
                e.setEmailContato(empresa.getEmailContato());
                return true;
            }
        }
        return false;
    }

    
}