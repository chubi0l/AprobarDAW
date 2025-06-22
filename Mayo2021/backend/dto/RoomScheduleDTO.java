package Mayo2021.backend.dto;

public record RoomScheduleDTO (
    Long id,
    boolean free,
    String hour,
    String reserver
) {
    
}
