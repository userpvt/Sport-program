package by.project.dto;

import by.project.entity.Gender;
import by.project.entity.Level;
import by.project.entity.Period;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewProgramDto {

    private String name;
    private String author;
    private Integer days;
    private Gender gender;
    private Level level;
    private Period period;
    private Integer categoryId;
}