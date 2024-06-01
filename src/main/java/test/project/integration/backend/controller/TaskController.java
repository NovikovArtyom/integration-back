package test.project.integration.backend.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import test.project.integration.backend.dto.TaskDto;
import test.project.integration.backend.entity.TaskEntity;
import test.project.integration.backend.service.TaskService;

import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/taskApi")
@CrossOrigin
@Slf4j
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public Collection<TaskEntity> getAllTasks() {
        log.info("Получен GET-запрос на эндпоинт /tasks");
        return taskService.getAllTasks();
    }

    @GetMapping("/secured")
    public String userAccess(Principal principal) {
        if (principal == null) {
            return null;
        }
        return principal.getName();
    }

    @PostMapping("/new")
    public TaskDto createTask(@Valid @RequestBody TaskDto taskDto) {
        log.info("Получен POST-запрос на эндпоинт /new");
        return taskService.createTask(taskDto);
    }
}
