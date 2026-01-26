package practice.backend.smartschool.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponseDTO {
    private String username;
    private String token;
    private String tokenType;
}
