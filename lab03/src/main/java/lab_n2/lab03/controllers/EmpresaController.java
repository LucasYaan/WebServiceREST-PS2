package lab_n2.lab03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lab_n2.lab03.model.Empresa;
import lab_n2.lab03.model.VagaEstagio;
import lab_n2.lab03.repos.EmpresaRepo;


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

    @SuppressWarnings("null")
    @PostMapping("/mackenzie/empresas")
    public Empresa createEmpresa(@RequestBody Empresa e){
        return empresaRepo.save(e);
    }

    @SuppressWarnings("null")
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
            e.setNomeFantasia(empresa.getNomeFantasia());
            e.setCnpj(empresa.getCnpj());
            e.setEmailContato(empresa.getEmailContato());
            empresaRepo.save(e);
            return true;
        }).orElse(false);
    }

    @SuppressWarnings("null")
    @PutMapping("/mackenzie/empresas/{id}/vagas")
    public boolean addVagaToEmpresa(@PathVariable long id, @RequestBody VagaEstagio vaga) {
        return empresaRepo.findById(id).map(empresa -> {
            vaga.setEmpresa(empresa);
            empresaRepo.save(empresa);
            return true;
        }).orElse(false);
    }
}