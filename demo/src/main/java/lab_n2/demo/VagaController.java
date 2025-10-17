package lab_n2.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class VagaController {
    private List<Vaga> vagas;

    public VagaController() {
        vagas = new ArrayList<>();
        vagas.add(new Vaga(1,"Desenvolvedor Java","Atuação em projetos backend com Java e Spring. Experiência desejada em APIs REST","2025-10-01",true,1));
        vagas.add(new Vaga(2,"Analista de Suporte Técnico","Suporte a clientes, resolução de chamados e participação em treinamentos internos.","2025-09-27",true,2));
        vagas.add(new Vaga(3,"Engenheiro de Software","Desenvolvimento de soluções para sistemas corporativos, integração e automação.","2025-10-03",true,3));
        vagas.add(new Vaga(4,"Analista de Dados","Manipulação e análise de grandes volumes de dados. Conhecimentos de SQL e Python","2025-09-18",true,4));
        vagas.add(new Vaga(5,"Designer Digital","Criação de materiais gráficos, UX/UI e participação em campanhas de marketing","2025-09-30",true,5));
        vagas.add(new Vaga(6,"Consultor de Projetos","Elaboração e acompanhamento de projetos empresariais e treinamentos.","2025-10-06",true,6));
        vagas.add(new Vaga(7,"Programador Full Stack","Desenvolvimento de aplicações web frontend e backend com foco em automação","2025-10-04",true,7));
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