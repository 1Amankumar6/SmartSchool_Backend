package practice.backend.smartschool.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "students",
        indexes = {
                @Index(name = "idx_student_roll", columnList = "rollNumber"),
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // Unique within a class
    @Column(nullable = false)
    private Integer rollNumber;

    @Column(nullable = false, length = 100)
    private String name;

//    @Column(nullable = false, unique = true, length = 120)
//    private String email;

    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    // 🔥 MANY students → ONE class
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_section_id", nullable = false)
    private ClassSection classSection;

    // Calculated value (can be updated periodically)
    private Double averageMarks;

    @Column(nullable = false)
    private Boolean active = true;
}
