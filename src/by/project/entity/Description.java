package by.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Description {

    private Long id;
    private String name;
    private int days;
    private Period period;
    private Level level;
    private String type;
    private String specification;
    private Category category;
}