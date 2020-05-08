package by.project.service;

import by.project.dto.LoginDto;
import by.project.entity.Role;
import by.project.entity.User;
import lombok.experimental.UtilityClass;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@UtilityClass
public class LoginService {

    private static final Map<LoginDto, User> USERS = new HashMap<>();


    static {
        USERS.put(new LoginDto("Ivan","111"),new User(1L,"I.Ivanov",Role.ADMIN));
        USERS.put(new LoginDto("Sveta","111"),new User(2L,"S.Petrova",Role.USER));
    }

    public static Optional<User> login(LoginDto loginDto) {
        return Optional.ofNullable(USERS.get(loginDto));
    }
}