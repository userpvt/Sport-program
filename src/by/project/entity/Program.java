package by.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Program {

    private Long id;
    private String name;
    private String author;
    private int days;
    private Gender gender;
    private Level level;
    private Period period;
    private Category category;
}