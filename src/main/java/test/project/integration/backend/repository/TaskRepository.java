package test.project.integration.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.project.integration.backend.entity.TaskEntity;

import java.util.Collection;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
