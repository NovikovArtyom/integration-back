package test.project.integration.backend.security;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
