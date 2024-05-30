package test.project.integration.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import test.project.integration.backend.dto.TaskDto;
import test.project.integration.backend.dto.UserDto;
import test.project.integration.backend.entity.TaskEntity;
import test.project.integration.backend.service.TaskService;

import java.util.Collection;

@RestController
@RequestMapping
@CrossOrigin
@Slf4j
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public Collection<TaskEntity> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/new")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }
}
