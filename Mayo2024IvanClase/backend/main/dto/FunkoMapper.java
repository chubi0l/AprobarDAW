package backend.main.controller.dto;

@Mapper
public interface FunkoMapper {
    public List<FunkoDTO> toDTOs(List<Funko> funkos);
    public Funko toDomain(FunkoDTO funko);
}
