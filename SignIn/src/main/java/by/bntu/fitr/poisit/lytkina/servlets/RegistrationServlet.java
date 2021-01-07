package by.bntu.fitr.poisit.lytkina.servlets;

import by.bntu.fitr.poisit.lytkina.bean.User;
import by.bntu.fitr.poisit.lytkina.dao.UserDAO;
import by.bntu.fitr.poisit.lytkina.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/registration.jsp");
        view.forward(req, resp);
        if (req.getSession().getAttribute("LoginIsNotUnique")!= null){
            req.getSession().removeAttribute("LoginIsNotUnique");
        }
        if (req.getSession().getAttribute("RepeatPasswordIsNotUnique")!= null){
            req.getSession().removeAttribute("RepeatPasswordIsNotUnique");
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputLogin = req.getParameter("login");
        String inputPassword = req.getParameter("password");
        String inputRepeatPassword = req.getParameter("repeatPassword");
        req.setAttribute("LoginIsNotUnique", req.getSession().getAttribute("LoginIsNotUnique"));

        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);

        if(userService.checkIfLoginUnique(inputLogin)){
            if (UserService.checkIfPasswordEqualsRepeatPassword(inputPassword, inputRepeatPassword)){
                UserDAO.addUser(inputLogin, inputPassword);
                resp.sendRedirect("/index");
            }else {

                req.getSession().setAttribute("RepeatPasswordIsNotUnique", "Passwords do not match!");
                resp.sendRedirect("/registration");
            }
        }else {
            req.getSession().setAttribute("LoginIsNotUnique", "The login is already in the system. Try one more time");
            resp.sendRedirect("/registration");
        }
    }
}
