package Julio2022.backend.controller;

import java.util.List;

import Julio2022.backend.dto.TaskDTO;
import Julio2022.backend.model.Task;
import Julio2022.backend.service.TaskService;
import Mayo2023.backend.model.Contact;

public class TaskController {
    @Autowired
    private TaskService taskService;

    @GettMapping("/getTasks")
    public String getTasks() {
        model.addAttribute("tasks", taskService.getTasks());

		return "index";
    }

    @PostMapping("/createTask")
    public String createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);

	    return "redirect:/";
    }

    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        Task deletedTask = taskService.deleteTask(id);
        
        return "redirect:/";
    }
}
