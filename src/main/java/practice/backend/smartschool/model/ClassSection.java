package practice.backend.smartschool.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "class_sections",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"grade", "section", "academicYear"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Example: 1 to 12
    @Column(nullable = false)
    private Integer grade;

    // A, B, C
    @Column(nullable = false, length = 5)
    private String section;

    // Example: 2024-2025
    @Column(nullable = false, length = 20)
    private String academicYear;

    @Column(nullable = false)
    private Integer maxStudents;

    // Optional: class teacher
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_teacher_id")
    private Teacher classTeacher;

    @Column(nullable = false)
    private Boolean active = true;
}
