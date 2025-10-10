@RestController
public class EstudanteController {
    private List<Estudante> estudantes;
    public EstudanteController() {
        estudantes = new ArrayList<>();
        estudantes.add(new Estudante(1,"Eduardo",1275,"SI"));
        estudantes.add(new Estudante(2,"Lucas",1272,"SI"));
        estudantes.add(new Estudante(3,"Daniel",1270,"ADM"));
    }

    @GetMapping("/mackenzie/alunos")
    public List<Estudante> getEstudantes(){
        return estudantes;
    }
    @GetMapping("/mackenzie/alunos/{id}")
    public Estudante getEstudante(@PathVariable long id){
        for(Estudante e:estudantes){
            if(id==e.getId()){
                return e;
            }
        }
        return null;
    }
    @PostMapping("/mackenzie/alunos")
    public Estudante create(@RequestBody Estudante e){
        long maior = 0;
        for(Estudante estudante: estudantes){
            if (estudante.getId() > maior){
                maior = estudante.getId();
            }
        }
        e.setId(maior + 1);
        estudantes.add(e);
        return e;
    }
}