@RestController
public class VagaController {
    private List<Vaga> vagas;

    public VagaController() {
        vagas = new ArrayList<>();
        vagas.add(new Vaga(1,"Dev Backend","Aos amantes de java","Spring Boot, Java, SQL"));
    }

    @GetMapping("/mackenzie/alunos")
    public List<Vaga> getvagas() {
        return vagas;
    }
    @GetMapping("/mackenzie/alunos/{id}")
    public Vaga getVaga(@PathVariable long id) {
        for(Vaga v : vagas) {
            if(id == v.getId()){
                return v;
            }
        }
        return null;
    }
    @PostMapping("/mackenzie/alunos")
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