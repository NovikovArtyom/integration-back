package test.project.integration.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import test.project.integration.backend.enums.Role;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String fullName;
    String login;
    String password;
    @Enumerated(EnumType.STRING)
    Role role;
}
