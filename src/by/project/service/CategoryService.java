package by.project.service;

import by.project.dao.CategoryDao;
import by.project.dao.ProgramDao;
import by.project.dto.ViewCategoryBasicInfoDto;
import by.project.dto.ViewProgramBasicInfoDto;
import by.project.entity.Category;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryService {

    private static final CategoryService INSTANCE = new CategoryService();

    public List<Category> findAll() {
        return CategoryDao.getInstance().findAll();
    }

    public static CategoryService getInstance() {
        return INSTANCE;
    }
}