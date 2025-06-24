@Service
public class AlumnoService {
    
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @Autowired
    private AlumnoMapper alumnoMapper;
    
    public List<AlumnoDTO> findAll() {
    
        return alumnoMapper.toAlumnoDTOList(alumnoRepository.findAll());
    }
    
    public Optional<AlumnoDetailDTO> findById(Long id) {

        return alumnoRepository.findById(id).map(alumnoMapper::toAlumnoDetailDTO);
    }
}