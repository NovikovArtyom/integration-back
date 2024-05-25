package test.project.integration.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
@Data
@AllArgsConstructor
public class TaskDto {
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String description;
}
