package Julio2022.backend.service;

import java.util.List;

import Julio2022.backend.dto.TaskDTO;
import Julio2022.backend.dto.TaskMapper;
import Julio2022.backend.model.Task;
import Julio2022.backend.repository.TaskRepository;
import Mayo2023.backend.model.Contact;

public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public TaskDTO getTask(Long id) {
        return taskMapper.toDTO(taskRepository.findById(id));
    }

    public List<TaskDTO> getTasks() {
        return taskMapper.toDTOs(taskRepository.findAll());
    }

    public TaskDTO createTask(TaskDTO taskDTO) {      

        if (taskRepository.findById(contactDTO.id()).isPresent()) {
			return null;
		}

		Task task = taskMapper.toDomain(taskDTO);

        updateTask(task);

		taskRepository.save(task);

		return taskMapper.toDTO(task);
    }

    public TaskDTO deleteTask(Long id) {
        Task task = taskRepository.findById(contactDTO.id()).orElseThrow();

		TaskDTO taskDTO = taskMapper.toDTO(task);

		taskRepository.deleteById(id);

		return (taskDTO);
    }

    public Task updateTask(Task task) {
        if (task.getDescription() != null) {
                task.setDescription(task.getDescription().toUpperCase());
        }
        return task;
    }
}
