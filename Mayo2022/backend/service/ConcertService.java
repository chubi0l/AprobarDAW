package Mayo2022.backend.service;

import Mayo2022.backend.dto.ConcertMapper;
import Mayo2022.backend.repository.ConcertRepository;

@Service
public class ConcertService {
   
    @Autowired
    private ConcertRepository repository;
    
    @Autowired
    private ConcertMapper mapper;

    public List<ConcertDTO> getConcerts() {
        return mapper.toDTOs(repository.findAll());
    }

    public ConcertDTO createConcert(ConcertDTO concertDTO) {
        List<Concert> concertsByRoom = repository.findByRoom(concertDTO.room());
        List<Concert> concertsByDate = repository.findByDate(concertDTO.date());

        if (!concertsByRoom.isEmpty() || !concertsByDate.isEmpty()) {
            return null;
        }
        
        Concert concert = mapper.toDomain(concertDTO);

        repository.save(concert);

        return toDTO(concert);
    }
}
