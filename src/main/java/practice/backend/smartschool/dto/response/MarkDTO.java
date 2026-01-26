package practice.backend.smartschool.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarkDTO {
    private String Subject;
    private Integer score;
}
