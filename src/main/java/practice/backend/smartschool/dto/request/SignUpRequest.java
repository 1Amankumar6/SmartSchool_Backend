package practice.backend.smartschool.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpRequest {

    @NotBlank
    @Size(min = 4, max = 20)
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, max = 30)
    private String password;

    // PRINCIPAL / TEACHER / STUDENT
    @NotBlank(message = "Give me the role")
    private String role;
}
