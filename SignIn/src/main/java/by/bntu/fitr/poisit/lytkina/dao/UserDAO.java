package by.bntu.fitr.poisit.lytkina.dao;

import by.bntu.fitr.poisit.lytkina.bean.Role;
import by.bntu.fitr.poisit.lytkina.bean.User;
import by.bntu.fitr.poisit.lytkina.config.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.bntu.fitr.poisit.lytkina.dao.Queries.ADD_USER;
import static by.bntu.fitr.poisit.lytkina.dao.Queries.SELECT_ALL_USERS;

public class UserDAO {

    public List<User> getAllUsers() throws SQLException {
        Connection connection = DBConnector.getConnection();
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(SELECT_ALL_USERS);
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            User user = User.builder()
                    .id(resultSet.getInt(1))
                    .login(resultSet.getString(2))
                    .password(resultSet.getString(3))
                    .role(Role.valueOf(resultSet.getString(4)))
                    .build();
            users.add(user);
        }
        return users;
    }
    public static void addUser(String login, String password) throws SQLException {
        Connection connection = DBConnector.getConnection();
        Statement st = connection.createStatement();
        int rowsUpdated = st.executeUpdate(String.format(ADD_USER, login, password));
    }
}
