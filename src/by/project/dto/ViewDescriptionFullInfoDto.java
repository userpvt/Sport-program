package by.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewDescriptionFullInfoDto {

    private String name;
    private Integer days;
    private String period;
    private String level;
    private String type;
    private String specification;
    private String categoryName;
}