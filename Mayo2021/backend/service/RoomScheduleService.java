package Mayo2021.backend.service;

import java.util.List;

import Mayo2021.backend.dto.RoomScheduleDTO;
import Mayo2021.backend.dto.RoomScheduleMapper;
import Mayo2021.backend.model.RoomSchedule;
import Mayo2021.backend.repository.RoomScheduleRepository;

@Service
public class RoomScheduleService {
    
    @Autowired
    private RoomScheduleMapper mapper;

    @Autowired
    private RoomScheduleRepository repository;

    public List<RoomScheduleDTO> getSchedules() {
        return mapper.toDTOs(repository.findAll());
    }

    public RoomScheduleDTO getSchedule(Long id) {
        return mapper.toDTO(repository.findById(id));
    }

    public RoomScheduleDTO reserveRoom(Long id, String reserverName) {
        RoomSchedule schedule = repository.findById(id).orElseThrow();
        schedule.setFree(false);
        schedule.setReserver(reserverName);
        return mapper.toDTO(repository.save(schedule));
    }

    public RoomScheduleDTO cancelReserve(Long id) {
        RoomSchedule schedule = repository.findById(id).orElseThrow();
        schedule.setFree(true);
        schedule.setReserver(null);
        return mapper.toDTO(repository.save(schedule));
    }
}
