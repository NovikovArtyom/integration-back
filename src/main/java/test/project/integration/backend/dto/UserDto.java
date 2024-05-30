package test.project.integration.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import test.project.integration.backend.enums.Role;

@Data
@AllArgsConstructor
public class UserDto {
    Long id;
    String fullName;
    String login;
    String password;
    Role role;
}
