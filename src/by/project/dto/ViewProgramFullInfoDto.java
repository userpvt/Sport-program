package by.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewProgramFullInfoDto {

    private String name;
    private String author;
    private Integer days;
    private String gender;
    private String level;
    private String period;
    private String categoryName;
}