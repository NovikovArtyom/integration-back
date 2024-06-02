package test.project.integration.backend.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.project.integration.backend.dto.TaskDto;
import test.project.integration.backend.service.TaskService;

import java.security.Principal;

@RestController
@RequestMapping("/taskApi")
@Slf4j
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTasks(Principal principal) {
        log.info("Получен GET-запрос на эндпоинт /tasks");
        log.info(String.valueOf(principal));
        if (principal == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(taskService.getAllTasks());
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
