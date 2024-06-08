package test.project.integration.backend.dto;

import lombok.experimental.UtilityClass;
import test.project.integration.backend.entity.TaskEntity;

@UtilityClass
public class TaskMapper {
    public static TaskDto toTaskDto(TaskEntity taskEntity) {
        return new TaskDto(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription()
        );
    }

    public static DoneTaskDto toDoneTaskDto(TaskEntity taskEntity) {
        return new DoneTaskDto(taskEntity.getDone());
    }

    public static TaskEntity toTaskEntity(TaskDto taskDto) {
        return new TaskEntity(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getDescription(),
                null,
                null
        );
    }
}
