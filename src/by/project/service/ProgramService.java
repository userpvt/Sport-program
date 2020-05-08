package by.project.service;

import by.project.dao.ProgramDao;
import by.project.dto.CreateNewProgramDto;
import by.project.dto.ViewProgramBasicInfoDto;
import by.project.dto.ViewProgramFullInfoDto;
import by.project.entity.Category;
import by.project.entity.Program;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProgramService {

    private static final ProgramService INSTANCE = new ProgramService();

    public List<ViewProgramBasicInfoDto> findAll() {
        return ProgramDao.getInstance().findAll().stream()
                .map(it -> new ViewProgramBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public ViewProgramFullInfoDto findById(Long programId) {
        return ProgramDao.getInstance().findById(programId)
                .map(it -> ViewProgramFullInfoDto.builder()
                .name(it.getName())
                        .author(it.getAuthor())
                        .categoryName(it.getCategory().getName())
                        .days(it.getDays())
                        .gender(it.getGender().getDescription())
                        .level(it.getLevel().getDescription())
                        .period(it.getPeriod().getDescription())
                .build())
                .orElse(null);
    }

    public ViewProgramBasicInfoDto save(CreateNewProgramDto dto) {
        Program savedProgram = ProgramDao.getInstance().save(
                Program.builder()
                .name(dto.getName())
                .days(dto.getDays())
                .author(dto.getAuthor())
                .gender(dto.getGender())
                .level(dto.getLevel())
                .period(dto.getPeriod())
                .category(Category.builder().id(dto.getCategoryId()).build())
                .build());
        return new ViewProgramBasicInfoDto(savedProgram.getId(), savedProgram.getName());
    }

    public static ProgramService getInstance() {
        return INSTANCE;
    }
}