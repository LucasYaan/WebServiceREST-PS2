import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AreaController {
    @Autowired
    private AreaRepo areaRepo;

    @GetMapping("/mackenzie/areas")
    public Iterable<Area> getAreas(){
        return areaRepo.findAll();
    }

    @GetMapping("/mackenzie/areas/{id}")
    public Area getArea(@PathVariable long id){
        return areaRepo.findById(id).orElse(null);
    }

    @PostMapping("/mackenzie/areas")
    public area createarea(@RequestBody area e){
        return areaRepo.save(e);
    }

    @DeleteMapping("/mackenzie/areas/{id}")
    public boolean deleteArea(@PathVariable long id) {
        return areaRepo.findById(id).map(area -> {
            areaRepo.delete(area);
            return true;
        }).orElse(false);
    }

    @PutMapping("/mackenzie/areas/{id}")
    public boolean updateArea(@PathVariable long id, @RequestBody Area area) {
        return areaRepo.findById(id).map(a -> {
            a.setNome(area.getNome());
            areaRepo.save(a);
            return true;
        }).orElse(false);
    }

    
}