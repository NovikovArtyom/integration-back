package test.project.integration.backend.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.project.integration.backend.dto.DoneTaskDto;
import test.project.integration.backend.dto.TaskDto;
import test.project.integration.backend.dto.TaskMapper;
import test.project.integration.backend.entity.TaskEntity;
import test.project.integration.backend.service.TaskService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/taskApi")
@Slf4j
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks(Principal principal) {
        log.info("Получен GET-запрос на эндпоинт /tasks");
        log.info(String.valueOf(principal));
        if (principal == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<TaskDto> allTasksDto = taskService.getAllTasks(principal.getName()).stream()
                .map(TaskMapper::toTaskDto)
                .toList();
        return ResponseEntity.ok(allTasksDto);
    }

    @GetMapping("/secured")
    public String userAccess(Principal principal) {
        if (principal == null) {
            return null;
        }
        return principal.getName();
    }

    @PostMapping("/new")
    public ResponseEntity<TaskDto> createTask(Principal principal, @Valid @RequestBody TaskDto taskDto) throws Exception {
        log.info("Получен POST-запрос на эндпоинт /new");
        if (principal == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        TaskDto savedTaskDto = TaskMapper.toTaskDto(taskService.createTask(principal.getName(), TaskMapper.toTaskEntity(taskDto)));
        return ResponseEntity.ok(savedTaskDto);
    }

    @PatchMapping("/done/{taskId}")
    public ResponseEntity<?> doneTask(Principal principal,
                                      @Validated @RequestBody DoneTaskDto doneTaskDto,
                                      @PathVariable Long taskId) {
        log.info("Получен PATCH-запрос на эндпоинт /done/{taskId}");
        if (principal == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(taskService.doneTask(doneTaskDto, taskId));
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<?> deleteTask(Principal principal, Long taskId) {
        log.info("Получен DELETE-запрос на эндпоинт /delete/{itemId}");
        if (principal == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        taskService.deleteTask(taskId);
        return ResponseEntity.ok(String.format("Задача с id = %d", taskId));
    }
}
