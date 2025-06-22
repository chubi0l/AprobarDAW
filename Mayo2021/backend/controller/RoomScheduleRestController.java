package Mayo2021.backend.controller;

import Mayo2021.backend.dto.RoomScheduleDTO;
import Mayo2021.backend.service.RoomScheduleService;

@RestController
@RequestMapping("api/roomSchedules")
public class RoomScheduleRestController {
    
    @Autowired
    private RoomScheduleService roomScheduleService;

    @GetMapping("/")
    public List<RoomScheduleDTO> getSchedules () {
        return roomScheduleService.getSchedules();
    }

    @PutMapping("/{id}")
    public RoomScheduleDTO reserveRoom(@RequestParam String reserverName, @PathVariable Long id) {
        RoomScheduleDTO roomSchedule = roomScheduleService.getSchedule(id);
        return roomScheduleService.reserveRoom(roomSchedule, reserverName);
    }

    @PutMapping("/{id}")
    public RoomScheduleDTO cancelReserve(@PathVariable Long id) {
        RoomScheduleDTO roomSchedule = roomScheduleService.getSchedule(id);
        return roomScheduleService.cancelReserve(roomSchedule);
    }
}
