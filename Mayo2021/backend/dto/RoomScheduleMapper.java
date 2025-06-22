package Mayo2021.backend.dto;

public interface RoomScheduleMapper {
    public RoomScheduleDTO toDTO(RoomSchedule roomSchedule);
    public List<RoomScheduleDTO> toDTOs(List<RoomSchedule> roomSchedules);
    public RoomSchedule toDomain(RoomScheduleDTO roomScheduleDTO);
}