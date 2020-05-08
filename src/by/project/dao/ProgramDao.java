package by.project.dao;

import by.project.connection.ConnectionPool;
import by.project.entity.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProgramDao {

    private static final ProgramDao INSTANCE = new ProgramDao();

    private static final String FIND_ALL =
            "SELECT " +
            "p.id AS program_id," +
            "c.id AS category_id," +
            "c.name AS category_name," +
            "p.name AS program_name," +
            "p.author," +
            "p.days," +
            "p.gender," +
            "p.level, " +
            "p.period " +
            "FROM login_storage.program p " +
            "INNER JOIN login_storage.category c " +
            "ON p.category_id = c.id";

    private static final String SAVE = "INSERT INTO login_storage.program(name, author, days, gender, level, period, category_id) " +
            "VALUES (?,?,?,?,?,?,?)";

    private static final String FIND_BY_ID = FIND_ALL + " WHERE p.id = ?";

    public Program save(Program program) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setString(1, program.getName());
        preparedStatement.setString(2, program.getAuthor());
        preparedStatement.setInt(3, program.getDays());
        preparedStatement.setString(4, program.getGender().name());
        preparedStatement.setString(5, program.getLevel().name());
        preparedStatement.setString(6, program.getPeriod().name());
        preparedStatement.setInt(7, program.getCategory().getId());

        preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                program.setId(generatedKeys.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return program;
    }

    public List<Program> findAll() {
        List<Program> programs = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
            Program program = getProgramFromResultSet(resultSet);
            programs.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programs;
    }

    public Optional<Program> findById(Long programId) {
        Optional<Program> program = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
        preparedStatement.setLong(1, programId);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            program = Optional.of(getProgramFromResultSet(resultSet));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return program;
    }

    private Program getProgramFromResultSet(ResultSet resultSet) throws SQLException {
        return Program.builder()
                .id(resultSet.getLong("program_id"))
                .name(resultSet.getString("program_name"))
                .author(resultSet.getString("author"))
                .days(resultSet.getInt("days"))
                .gender(Gender.valueOf(resultSet.getString("gender")))
                .level(Level.valueOf(resultSet.getString("level")))
                .period(Period.valueOf(resultSet.getString("period")))
                .category(Category.builder()
                        .id(resultSet.getInt("category_id"))
                        .name(resultSet.getString("category_name"))
                        .build())
                .build();
    }

    public static ProgramDao getInstance() {
        return INSTANCE;
    }
}