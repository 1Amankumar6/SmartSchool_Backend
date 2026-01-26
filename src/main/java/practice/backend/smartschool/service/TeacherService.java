package practice.backend.smartschool.service;

import org.springframework.stereotype.Service;
import practice.backend.smartschool.dto.request.AddMarksDTO;
import practice.backend.smartschool.dto.response.*;

import java.util.List;

@Service
public class TeacherService {

    public TeacherResponseDTO getProfile() {
        // TODO: Fetch teacher info
        return new TeacherResponseDTO(1L, "Mr. X", "teacher@example.com");
    }

    public List<String> getClasses() {
        // TODO: Fetch assigned classes
        return List.of("Class 1", "Class 2");
    }

    public List<StudentResponseDTO> getStudents(Long classId) {
        // TODO: Fetch students by classId
        return List.of(

        );
    }

    public StatusDTO addMarks(Long classId, AddMarksDTO marks) {
        // TODO: Add marks to DB
        return new StatusDTO("Marks added successfully for student " + marks.getStudentId());
    }

    public List<RankDTO> getRanking(Long classId) {
        // TODO: Calculate class ranking
        return List.of(
                new RankDTO(1),
                new RankDTO(2),
                new RankDTO(3)
        );
    }
}
