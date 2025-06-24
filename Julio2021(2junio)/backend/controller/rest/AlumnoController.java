@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    
    @Autowired
    private AlumnoService alumnoService;
    
    @GetMapping
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        return ResponseEntity.ok(alumnoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {

        return alumnoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
                
    }
}