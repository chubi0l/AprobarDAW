package Mayo2022.backend.dto;

public interface ConcertMapper {
    public ConcertDTO toDTO(Concert concert);
    public List<ConcertDTO> toDTOs(ConcertDTO concertDTO);
    public Concert toDomain(ConcertDTO concertDTO);
}
