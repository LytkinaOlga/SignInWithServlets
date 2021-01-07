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

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("isAuthorized", false);

        RequestDispatcher view = req.getRequestDispatcher("/index.jsp");
        view.forward(req, resp);
        if (req.getSession().getAttribute("WrongLoginOrPassword")!= null){
            req.getSession().removeAttribute("WrongLoginOrPassword");
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String inputLogin = req.getParameter("login");
        String inputPassword = req.getParameter("password");

        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);

        if (userService.checkIfLoginAndPasswordEqual(inputLogin, inputPassword)){

            req.getSession().setAttribute("login", inputLogin);
            req.getSession().setAttribute("isAuthorized", true);
            req.getSession().setAttribute("role", userService.findRole(inputLogin, inputPassword));

            resp.sendRedirect("/home");
        }else {
            req.getSession().setAttribute("WrongLoginOrPassword", "Wrong login or password");
            resp.sendRedirect("/index");
        }
    }
}
