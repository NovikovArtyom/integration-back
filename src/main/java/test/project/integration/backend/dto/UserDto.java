package test.project.integration.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import test.project.integration.backend.enums.Role;

@Data
@AllArgsConstructor
public class UserDto {
    Long id;
    @NonNull
    String username;
    @NonNull
    @Email
    String email;
    @NonNull
    @Size(min = 4, message = "Минимальная длинна password пользователя - 4 символа")
    String password;
    @NonNull
    Role role;
}
