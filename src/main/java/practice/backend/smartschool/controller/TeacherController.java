package practice.backend.smartschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.backend.smartschool.service.StudentService;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final StudentService studentService;

    @GetMapping("/health")
    public String teacherHealth() {
        return "Teacher Health service is active at " + LocalDateTime.now();
    }
}
