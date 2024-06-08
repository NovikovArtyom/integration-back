package test.project.integration.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class DoneTaskDto {
    @NonNull
    private Boolean done;
}
