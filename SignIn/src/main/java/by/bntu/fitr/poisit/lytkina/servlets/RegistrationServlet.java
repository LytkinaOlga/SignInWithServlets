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
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputLogin = req.getParameter("login");
        String inputPassword = req.getParameter("password");
        String inputRepeatPassword = req.getParameter("repeatPassword");
        req.setAttribute("LoginIsNotUnique", req.getSession().getAttribute("LoginIsNotUnique"));

        if(UserService.checkIfLoginUnique(inputLogin)){
            if (UserService.checkIfPasswordEqualsRepeatPassword(inputPassword, inputRepeatPassword)){
                UserDAO.addUser(inputLogin, inputPassword);
                resp.sendRedirect("/index");
            }else {
                resp.sendRedirect("/registration");
            }
        }else {
            req.getSession().setAttribute("LoginIsNotUnique", false);
            resp.sendRedirect("/registration");
        }
    }
}
