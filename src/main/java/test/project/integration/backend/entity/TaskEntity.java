package test.project.integration.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import test.project.integration.backend.dto.UserDto;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author", nullable = false)
    private UserEntity author;
    private Boolean done;
}
