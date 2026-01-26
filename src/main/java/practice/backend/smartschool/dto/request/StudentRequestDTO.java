package practice.backend.smartschool.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import practice.backend.smartschool.model.Gender;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDTO {
    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private Integer rollNumber;

    @NotBlank
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    private Gender gender;

//    @NotNull
//    private Integer classSectionId;
}
