package test.project.integration.backend.service;

import org.springframework.stereotype.Service;
import test.project.integration.backend.dto.TaskDto;
import test.project.integration.backend.dto.TaskMapper;
import test.project.integration.backend.entity.TaskEntity;
import test.project.integration.backend.repository.TaskRepository;

import java.util.Collection;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Collection<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        TaskEntity taskEntity = TaskMapper.toTaskEntity(taskDto);
        return TaskMapper.toTaskDto(taskRepository.save(taskEntity));
    }
}
