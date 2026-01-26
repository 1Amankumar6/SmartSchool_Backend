package practice.backend.smartschool.dto.response;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import practice.backend.smartschool.model.Gender;

@Data
@AllArgsConstructor
@Builder
public class StudentResponseDTO {
    private Long id;
    private String name;
    private Integer rollNumber;
    private Gender gender;
    private Integer classSectionId;
    private Integer age;

}
