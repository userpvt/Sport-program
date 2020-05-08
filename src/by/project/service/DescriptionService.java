package by.project.service;

import by.project.dao.DescriptionDao;
import by.project.dto.ViewDescriptionBasicInfoDto;
import by.project.dto.ViewDescriptionFullInfoDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DescriptionService {

    private static final DescriptionService INSTANCE = new DescriptionService();

    public List<ViewDescriptionBasicInfoDto> findAll() {
        return DescriptionDao.getInstance().findAll().stream()
                .map(it -> new ViewDescriptionBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public ViewDescriptionFullInfoDto findById(Long descriptionId) {
        return DescriptionDao.getInstance().findById(descriptionId)
                .map(it -> ViewDescriptionFullInfoDto.builder()
                        .name(it.getName())
                        .days(it.getDays())
                        .period(it.getPeriod().getDescription())
                        .level(it.getLevel().getDescription())
                        .type(it.getType())
                        .specification(it.getSpecification())
                        .categoryName(it.getCategory().getName())
                        .build())
                .orElse(null);
    }

    public static DescriptionService getInstance() {
        return INSTANCE;
    }
}