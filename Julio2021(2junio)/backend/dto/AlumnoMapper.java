//imports
public @Component

public class AlumnoMapper {
    
    public AlumnoDTO toAlumnoDTO(Alumno alumno) {
        AlumnoDTO dto = new AlumnoDetailDTO();

        dto.setId(alumno.getId());

        dto.setNombre(alumno.getNombre());

        dto.setDireccion(alumno.getDireccion());

        dto.setEmail(alumno.getEmail());

        return dto;
    }
    
    public List<AlumnoDTO> toAlumnosDTOList(List<Alumno> alumnos) {
        return alumnos.stream()
                .map(this::toAlumnoDTO)
                .collect(Collectors.toList());
    }
}
