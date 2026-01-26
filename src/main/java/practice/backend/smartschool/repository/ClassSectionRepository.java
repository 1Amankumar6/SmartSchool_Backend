package practice.backend.smartschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.backend.smartschool.model.ClassSection;

public interface ClassSectionRepository extends JpaRepository<ClassSection, Integer> {

}
