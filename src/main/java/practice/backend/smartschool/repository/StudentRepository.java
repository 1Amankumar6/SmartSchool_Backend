package practice.backend.smartschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.backend.smartschool.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByRollNumber(Integer rollNumber);
    boolean existsByUserEmail(String email);
    boolean existsByUserUsername(String username);
    Optional<Student> findByIdAndActiveTrue(Long id);
    boolean existsByRollNumberAndClassSection_Id(Integer rollNumber, Long classSectionId);
    List<Student> findByClassSection_Id(Long classSection);
}
