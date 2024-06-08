package test.project.integration.backend.service;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import test.project.integration.backend.dto.DoneTaskDto;
import test.project.integration.backend.dto.TaskDto;
import test.project.integration.backend.dto.TaskMapper;
import test.project.integration.backend.entity.TaskEntity;
import test.project.integration.backend.repository.TaskRepository;
import test.project.integration.backend.repository.UserRepository;

import java.util.Collection;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<TaskEntity> getAllTasks(String name) {
        return taskRepository.findAllByAuthor_Username(name);
    }

    @Override
    public TaskEntity createTask(String name, TaskEntity taskEntity) {
        if (userRepository.existsByUsername(name)) {
            taskEntity.setAuthor(userRepository.findUserEntityByUsername(name).orElseThrow(() -> new RuntimeException()));
            taskEntity.setDone(false);
        }
        return taskRepository.save(taskEntity);
    }

    @Override
    public void deleteTask(Long taskId) {
        if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
        } else {
            throw new RuntimeException("");
        }
    }

    @Override
    public DoneTaskDto doneTask(DoneTaskDto doneTaskDto, Long taskId) {
        if (taskRepository.existsById(taskId)) {
            TaskEntity task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException());
            task.setDone(doneTaskDto.getDone());
            return TaskMapper.toDoneTaskDto(taskRepository.save(task));
        } else {
            throw new RuntimeException("");
        }
    }
}