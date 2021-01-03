package by.bntu.fitr.poisit.lytkina.service;

import by.bntu.fitr.poisit.lytkina.bean.User;
import by.bntu.fitr.poisit.lytkina.dao.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    public static boolean checkIfLoginUnique(String inputLogin) throws SQLException {
        List<User> users = UserDAO.getAllUsers();
        for (User user: users){
            if (user.getLogin().equals(inputLogin)){
                return false;
            }
        }
        return true;

    }

    public static boolean checkIfLoginAndPasswordEqual(String inputLogin, String inputPassword) throws SQLException {
        List<User> users = UserDAO.getAllUsers();
        for (User user: users){
            if (user.getLogin().equals(inputLogin) && user.getPassword().equals(inputPassword)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfPasswordEqualsRepeatPassword(String password, String repeatPassword){
        if (password.equals(repeatPassword)){
            return true;
        }else return false;
    }

    public static String findRole(String inputLogin, String inputPassword) throws SQLException {
        List<User> users = UserDAO.getAllUsers();
        for (User user: users){
            if (user.getLogin().equals(inputLogin) && user.getPassword().equals(inputPassword)){
                return user.getRole().name();
            }
        }
        return null;
    }
}
