package practice.backend.smartschool.dto.request;

import lombok.Data;

@Data
public class AddMarksDTO {
    private Long studentId;
    private String subject;
    private Integer score;
}
