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
        if (repository.findById(concertDTO.room && concertDTO.date()).isPresent()) {
            return null;
        }
        
        Concert concert = mapper.toDomain(concertDTO);

        repository.save(concert);

        return toDTO(concert);
    }
}
