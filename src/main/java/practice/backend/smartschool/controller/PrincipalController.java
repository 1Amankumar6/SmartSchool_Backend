package practice.backend.smartschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.backend.smartschool.dto.request.TeacherCreateDTO;
import practice.backend.smartschool.dto.response.ClassReportDTO;
import practice.backend.smartschool.dto.response.StudentResponseDTO;
import practice.backend.smartschool.dto.response.TeacherResponseDTO;
import practice.backend.smartschool.service.ClassService;
import practice.backend.smartschool.service.PrincipalService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/principal")
public class PrincipalController {

    private final PrincipalService principalService;

    public PrincipalController(PrincipalService principalService) {
        this.principalService = principalService;
    }

    @PostMapping("/teachers")
    public ResponseEntity<TeacherResponseDTO> createTeacher(@RequestBody TeacherCreateDTO dto) {
        return ResponseEntity.ok(principalService.createTeacher(dto));
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherResponseDTO>> getTeachers() {
        return ResponseEntity.ok(principalService.getTeachers());
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDTO>> getStudents() {
        return ResponseEntity.ok(principalService.getStudents());
    }

    @GetMapping("/reports/class/{classId}")
    public ResponseEntity<ClassReportDTO> getClassReport(@PathVariable Long classId) {
        return ResponseEntity.ok(principalService.getClassReport(classId));
    }

    @GetMapping("/health")
    public String principalHealth(){
       return "Principal Health service is active at " + LocalDateTime.now();
   }
}
