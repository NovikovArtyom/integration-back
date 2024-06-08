package test.project.integration.backend.service;

import org.springframework.scheduling.config.Task;
import test.project.integration.backend.dto.DoneTaskDto;
import test.project.integration.backend.dto.TaskDto;
import test.project.integration.backend.entity.TaskEntity;

import java.util.Collection;
import java.util.List;

public interface TaskService {
    List<TaskEntity> getAllTasks(String name);

    TaskEntity createTask(String name, TaskEntity taskEntity) throws Exception;

    void deleteTask(Long taskId);

    DoneTaskDto doneTask(DoneTaskDto doneTaskDto, Long taskId);
}
