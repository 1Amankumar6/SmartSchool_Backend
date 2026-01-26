package practice.backend.smartschool.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.backend.smartschool.dto.request.StudentRequestDTO;
import practice.backend.smartschool.dto.response.MarkDTO;
import practice.backend.smartschool.dto.response.RankDTO;
import practice.backend.smartschool.dto.response.StudentResponseDTO;
import practice.backend.smartschool.service.StudentService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/health")
    public String studentHealth() {
           return "Student Health service is active at " + LocalDateTime.now();
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody @Valid StudentRequestDTO request){
        return ResponseEntity.ok(studentService.createStudent(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateStudent(@PathVariable Long id) {
        studentService.deactivateStudent(id);
        return ResponseEntity.noContent().build();
    }
}
