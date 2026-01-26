package practice.backend.smartschool.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import practice.backend.smartschool.dto.request.LoginRequestDTO;
import practice.backend.smartschool.dto.request.StudentRequestDTO;
import practice.backend.smartschool.dto.response.MarkDTO;
import practice.backend.smartschool.dto.response.RankDTO;
import practice.backend.smartschool.dto.response.StudentResponseDTO;

import java.util.List;

@Service
public interface StudentService {

    StudentResponseDTO createStudent(StudentRequestDTO request);

    StudentResponseDTO getStudentById(Long id);

    List<StudentResponseDTO> getStudentsByClass(Long classSectionId);

    void deactivateStudent(Long id);
}

