package practice.backend.smartschool.service;

import org.springframework.stereotype.Service;
import practice.backend.smartschool.dto.request.TeacherCreateDTO;
import practice.backend.smartschool.dto.response.*;

import java.util.List;

@Service
public class PrincipalService {

    public TeacherResponseDTO createTeacher(TeacherCreateDTO dto) {
        // TODO: Save teacher to DB
        return new TeacherResponseDTO(10L, dto.getName(), dto.getEmail());
    }

    public List<TeacherResponseDTO> getTeachers() {
        // TODO: Fetch all teachers
        return List.of(
                new TeacherResponseDTO(10L, "Mr. X", "teacher@example.com"),
                new TeacherResponseDTO(11L, "Ms. Y", "teacher2@example.com")
        );
    }

    public List<StudentResponseDTO> getStudents() {
        // TODO: Fetch all students
        return List.of();
    }

    public ClassReportDTO getClassReport(Long classId) {
        // TODO: Generate report
        return new ClassReportDTO(classId, List.of());
    }
}
