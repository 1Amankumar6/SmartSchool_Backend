package practice.backend.smartschool.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "teachers",
        indexes = {
                @Index(name = "idx_teacher_email", columnList = "email")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = false)
    private Boolean active = true;
}
