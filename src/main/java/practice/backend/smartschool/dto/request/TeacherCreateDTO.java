package practice.backend.smartschool.dto.request;

import lombok.Data;

@Data
public class TeacherCreateDTO {
    private String name;
    private String email;
    private String password;
}
