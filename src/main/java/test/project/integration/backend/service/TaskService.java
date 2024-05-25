package test.project.integration.backend.service;

import test.project.integration.backend.dto.TaskDto;
import test.project.integration.backend.entity.TaskEntity;

import java.util.Collection;

public interface TaskService {
    Collection<TaskEntity> getAllTasks();

    TaskDto createTask(TaskDto taskDto);
}
