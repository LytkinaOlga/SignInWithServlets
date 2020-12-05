package by.bntu.fitr.poisit.lytkina.servlets;

import by.bntu.fitr.poisit.lytkina.bean.User;
import by.bntu.fitr.poisit.lytkina.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminLogin = getServletContext().getInitParameter("adminLogin");

        RequestDispatcher view = req.getRequestDispatcher("/index.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminLogin = getServletContext().getInitParameter("adminLogin");
        String adminPassword = getServletContext().getInitParameter("adminPassword");

        String inputLogin = req.getParameter("login");
        String inputPassword = req.getParameter("password");

        if (UserService.checkIfLoginAndPasswordEqual(adminLogin, inputLogin, adminPassword, inputPassword)){
            resp.sendRedirect("/home.jsp");
        }else resp.sendRedirect("/index.jsp");

    }
}
