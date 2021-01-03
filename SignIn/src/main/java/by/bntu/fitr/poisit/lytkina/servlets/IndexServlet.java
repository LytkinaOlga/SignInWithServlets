package by.bntu.fitr.poisit.lytkina.servlets;

import by.bntu.fitr.poisit.lytkina.bean.User;
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

        RequestDispatcher view = req.getRequestDispatcher("/index.jsp");
        view.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String inputLogin = req.getParameter("login");
        String inputPassword = req.getParameter("password");

        if (UserService.checkIfLoginAndPasswordEqual(inputLogin, inputPassword)){

            req.getSession().setAttribute("login", inputLogin);
            req.getSession().setAttribute("isAuthorized", true);
            req.getSession().setAttribute("role", UserService.findRole(inputLogin, inputPassword));

            resp.sendRedirect("/home");
        }else {
            resp.sendRedirect("/index");
        }
    }
}
