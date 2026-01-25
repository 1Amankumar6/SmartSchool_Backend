package practice.backend.smartschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.backend.smartschool.service.ClassService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ClassService classService;

    @GetMapping("/health")
    public String principalHealth(){
       return "Principal Health service is active at " + LocalDateTime.now();
   }
}
