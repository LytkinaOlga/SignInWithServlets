package by.bntu.fitr.poisit.lytkina.service;

public class UserService {
    public static boolean checkIfLoginAndPasswordEqual(String existLogin, String inputLogin, String existPassword, String inputPassword){
        if (existLogin.equals(inputLogin) && existPassword.equals(inputPassword)){
            return true;
        }else return false;
    }
}
