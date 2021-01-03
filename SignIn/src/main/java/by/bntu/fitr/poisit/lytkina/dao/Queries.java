package by.bntu.fitr.poisit.lytkina.dao;

public class Queries {

    public static final String SELECT_ALL_USERS = "SELECT * FROM user_info;";
    public static final String ADD_USER = "INSERT INTO user_info (`login`, `pass`, `rol`) VALUES ('%s', '%s', 'USER');";
}
