package practice.backend.smartschool.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import practice.backend.smartschool.dto.request.StudentRequestDTO;
import practice.backend.smartschool.dto.response.StudentResponseDTO;
import practice.backend.smartschool.model.ClassSection;
import practice.backend.smartschool.model.Role;
import practice.backend.smartschool.model.Student;
import practice.backend.smartschool.model.User;
import practice.backend.smartschool.repository.ClassSectionRepository;
import practice.backend.smartschool.repository.StudentRepository;
import practice.backend.smartschool.repository.UserRepository;
import practice.backend.smartschool.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ClassSectionRepository classSectionRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public StudentResponseDTO createStudent(StudentRequestDTO request) {
        // 1. Find existing user
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found. Please signup first."));

// 2. Check user role
        if (user.getRole() != Role.ROLE_STUDENT) {
            throw new RuntimeException("User is not a STUDENT role");
        }

// 3. Check if already enrolled
        if (studentRepository.existsByUserUsername(user.getUsername())) {
            throw new RuntimeException("Student already enrolled");
        }

// 4. Create Student ONLY
        Student student = Student.builder()
                .user(user)
                .name(request.getName())
                .rollNumber(request.getRollNumber())
                .age(request.getAge())
                .gender(request.getGender())
//                .classSection(classSection)
                .active(true)
                .build();

        studentRepository.save(student);
        return mapToResponse(student);
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        return null;
    }

    @Override
    public List<StudentResponseDTO> getStudentsByClass(Long classSectionId) {
        return List.of();
    }

    @Override
    public void deactivateStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        student.setActive(false);
    }

    private StudentResponseDTO mapToResponse(Student student) {
        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .rollNumber(student.getRollNumber())
                .gender(student.getGender())
                .classSectionId(student.getClassSection().getId())
                .age(student.getAge())
                .build();
    }
}
