package by.project.dao;

import by.project.connection.ConnectionPool;
import by.project.entity.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDao {

    private static final CategoryDao INSTANCE = new CategoryDao();

    private static final String FIND_ALL = "SELECT id,name FROM login_storage.category";

    public List<Category> findAll() {
    List<Category> categories = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                Category category = Category.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public static CategoryDao getInstance() {
        return INSTANCE;
    }
}