package practice.backend.smartschool.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @PreAuthorize("hasAnyRole('TEACHER', 'PRINCIPAL')")
    public String viewAllStudents() {
        return "List of students";
    }

    @PreAuthorize("hasRole('STUDENT')")
    public String viewMyProfile() {
        return "Student profile data";
    }
}
