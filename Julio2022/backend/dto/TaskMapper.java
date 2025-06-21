package Julio2022.backend.dto;

public interface TaskMapper {
    public TaskDTO toDTO(Task task);
    public Task toDomain(TaskDTO taskDTO);
    public List<TaskDTO> toDTOs(List<Task> tasks);
}
