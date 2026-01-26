package practice.backend.smartschool.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherResponseDTO {
    private Long id;
    private String name;
    private String email;
}
