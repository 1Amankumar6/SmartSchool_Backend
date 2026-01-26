package practice.backend.smartschool.controller;

import ch.qos.logback.core.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.backend.smartschool.dto.request.AddMarksDTO;
import practice.backend.smartschool.dto.response.RankDTO;
import practice.backend.smartschool.dto.response.StatusDTO;
import practice.backend.smartschool.dto.response.StudentResponseDTO;
import practice.backend.smartschool.dto.response.TeacherResponseDTO;
import practice.backend.smartschool.service.StudentService;
import practice.backend.smartschool.service.TeacherService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/me")
    public ResponseEntity<TeacherResponseDTO> getProfile() {
        return ResponseEntity.ok(teacherService.getProfile());
    }

    @GetMapping("/classes")
    public ResponseEntity<List<String>> getClasses() {
        return ResponseEntity.ok(teacherService.getClasses());
    }

    @GetMapping("/classes/{classId}/students")
    public ResponseEntity<List<StudentResponseDTO>> getStudents(@PathVariable Long classId) {
        return ResponseEntity.ok(teacherService.getStudents(classId));
    }

    @PostMapping("/classes/{classId}/marks")
    public ResponseEntity<StatusDTO> addMarks(@PathVariable Long classId, @RequestBody AddMarksDTO marks) {
        return ResponseEntity.ok(teacherService.addMarks(classId, marks));
    }

    @GetMapping("/classes/{classId}/ranking")
    public ResponseEntity<List<RankDTO>> getRanking(@PathVariable Long classId) {
        return ResponseEntity.ok(teacherService.getRanking(classId));
    }

    @GetMapping("/health")
    public String teacherHealth() {
        return "Teacher Health service is active at " + LocalDateTime.now();
    }
}
