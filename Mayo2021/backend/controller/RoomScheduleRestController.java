package Mayo2021.backend.controller;

import java.util.List;

import Mayo2021.backend.dto.RoomScheduleDTO;
import Mayo2021.backend.service.RoomScheduleService;

@RestController
@RequestMapping("api/schedules")
public class RoomScheduleRestController {
    
    @Autowired
    private RoomScheduleService service;

    @GetMapping("/")
    public List<RoomScheduleDTO> getSchedules () {
        return service.getSchedules();
    }

    @PutMapping("/{id}/reserve")
    public RoomScheduleDTO reserveRoom(@RequestParam String reserverName, @PathVariable Long id) {
        return service.reserveRoom(id, reserverName);
    }

    @PutMapping("/{id}")
    public RoomScheduleDTO cancelReserve(@PathVariable Long id) {
        return service.cancelReserve(id);
    }
}
