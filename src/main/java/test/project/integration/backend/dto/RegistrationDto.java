package test.project.integration.backend.dto;

import lombok.Data;
import test.project.integration.backend.enums.Role;

@Data
public class RegistrationDto {
    private String username;
    private String email;
    private String password;
    private Role role;
}
