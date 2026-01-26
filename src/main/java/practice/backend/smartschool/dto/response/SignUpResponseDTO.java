package practice.backend.smartschool.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String role;
}
