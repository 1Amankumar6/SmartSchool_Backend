package practice.backend.smartschool.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @PreAuthorize("hasRole('PRINCIPAL')")
    public String createClass() {
        return "Class created successfully";
    }
}
