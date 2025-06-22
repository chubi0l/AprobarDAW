package Mayo2021.backend.service;

import Mayo2021.backend.dto.RoomScheduleDTO;
import Mayo2021.backend.dto.RoomScheduleMapper;
import Mayo2021.backend.repository.RoomScheduleRepository;

@Service
public class RoomScheduleService {
    
    @Autowired
    private RoomScheduleMapper mapper;

    @Autowired
    private RoomScheduleRepository repository;

    public List<RoomScheduleDTO> getSchedules() {
        return repository.findAll();
    }

    public RoomScheduleDTO getSchedule(Long id) {
        return repository.findById(id);
    }

    public RoomScheduleDTO reserveRoom(RoomScheduleDTO roomScheduleDTO, String reserverName) {
        mapper.toDomain(roomScheduleDTO);
        
        roomScheduleDTO.setFree(false);

        roomScheduleDTO.setReserver(reserverName);

        repository.save(roomScheduleDTO);

        return mapper.toDTO(roomScheduleDTO);

    }

    public RoomScheduleDTO cancelReserve(RoomScheduleDTO roomScheduleDTO) {
        mapper.toDomain(roomScheduleDTO);
        
        roomScheduleDTO.setFree(true);

        roomScheduleDTO.setReserver(null);

        repository.save(roomScheduleDTO);

        return mapper.toDTO(roomScheduleDTO);
    }
}
