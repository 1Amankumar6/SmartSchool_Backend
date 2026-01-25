package practice.backend.smartschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/health")
    public String studentHealth() {
           return "Student Health service is active at " + LocalDateTime.now();
    }
}
