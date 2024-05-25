package test.project.integration.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.project.integration.backend.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
