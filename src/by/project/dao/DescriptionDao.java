package by.project.dao;

import by.project.connection.ConnectionPool;
import by.project.entity.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DescriptionDao {

    private static final DescriptionDao INSTANCE = new DescriptionDao();

    private static final String FIND_ALL =
            "SELECT " +
                    "d.id AS description_id," +
                    "c.id AS category_id," +
                    "c.name AS category_name," +
                    "d.name AS description_name," +
                    "d.days," +
                    "d.period," +
                    "d.level, " +
                    "d.type," +
                    "d.specification " +
                    "FROM login_storage.description d " +
                    "INNER JOIN login_storage.category c " +
                    "ON d.category_id = c.id";

    private static final String FIND_BY_ID = FIND_ALL + " WHERE d.id = ?";


    public List<Description> findAll() {
        List<Description> descriptions = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                Description description = getDescriptionFromResultSet(resultSet);
                descriptions.add(description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descriptions;
    }

    public Optional<Description> findById(Long descriptionId) {
        Optional<Description> description = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, descriptionId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                description = Optional.of(getDescriptionFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return description;
    }


    private Description getDescriptionFromResultSet(ResultSet resultSet) throws SQLException {
        return Description.builder()
                .id(resultSet.getLong("description_id"))
                .name(resultSet.getString("description_name"))
                .days(resultSet.getInt("days"))
                .period(Period.valueOf(resultSet.getString("period")))
                .level(Level.valueOf(resultSet.getString("level")))
                .type(resultSet.getString("type"))
                .specification(resultSet.getString("specification"))
                .category(Category.builder()
                        .id(resultSet.getInt("category_id"))
                        .name(resultSet.getString("category_name"))
                        .build())
                .build();
    }

    public static DescriptionDao getInstance() {
        return INSTANCE;
    }
}