package by.bntu.fitr.poisit.lytkina.service;

import by.bntu.fitr.poisit.lytkina.bean.Role;
import by.bntu.fitr.poisit.lytkina.bean.User;
import by.bntu.fitr.poisit.lytkina.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;
    @Mock
    UserDAO userDAOMock;

    @Test
    public void checkIfLoginUniqueReturnFalse() throws SQLException {

        String login = "login";

        boolean expectedResult = false;

        List<User> expectedUserList = Arrays.asList(new User(1, login, "1", Role.USER),
                new User(2, "login2", "1", Role.USER),
                new User(3, "login 3", "1", Role.USER));

        Mockito.when(userDAOMock.getAllUsers())
                .thenReturn(expectedUserList);

        boolean actual = userService.checkIfLoginUnique(login);
        assertEquals(expectedResult, actual);
    }
    
    @Test
    public void checkIfLoginUniqueReturnTrue() throws SQLException {

        String login = "login";

        boolean expectedResult = true;

        List<User> expectedUserList = Arrays.asList(new User(1, "login1", "1", Role.USER),
                new User(2, "login2", "1", Role.USER),
                new User(3, "login 3", "1", Role.USER));

        Mockito.when(userDAOMock.getAllUsers())
                .thenReturn(expectedUserList);

        boolean actual = userService.checkIfLoginUnique(login);
        assertEquals(expectedResult, actual);
    }

    @Test
    public void checkIfLoginAndPasswordEqualReturnTrue() throws SQLException {
        String login = "login";
        String password = "password";

        boolean expected = true;

        List<User> expectedUserList = Arrays.asList(new User(1, "login", "password", Role.USER),
                new User(2, "login2", "1", Role.USER),
                new User(3, "login 3", "1", Role.USER));

        Mockito.when(userDAOMock.getAllUsers())
                .thenReturn(expectedUserList);

        boolean actual = userService.checkIfLoginAndPasswordEqual(login, password);
        assertEquals(expected, actual);
    }

    @Test
    public void checkIfLoginAndPasswordEqualReturnFalse() throws SQLException {
        String login = "login";
        String password = "password";

        boolean expected = false;

        List<User> expectedUserList = Arrays.asList(new User(1, "login1", "password1", Role.USER),
                new User(2, "login2", "1", Role.USER),
                new User(3, "login 3", "1", Role.USER));

        Mockito.when(userDAOMock.getAllUsers())
                .thenReturn(expectedUserList);

        boolean actual = userService.checkIfLoginAndPasswordEqual(login, password);
        assertEquals(expected, actual);
    }

}