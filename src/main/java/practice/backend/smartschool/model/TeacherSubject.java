package practice.backend.smartschool.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "teacher_subject",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"teacher_id", "subject_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MANY assignments → ONE teacher
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // MANY assignments → ONE subject
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
