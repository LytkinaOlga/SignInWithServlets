package by.bntu.fitr.poisit.lytkina.servlets;

import by.bntu.fitr.poisit.lytkina.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String adminLogin = getServletContext().getInitParameter("adminLogin");

        HttpSession session = req.getSession();

        req.setAttribute("login", session.getAttribute("login"));
        req.setAttribute("role", session.getAttribute("role"));

        RequestDispatcher view = req.getRequestDispatcher("/home.jsp");
        view.forward(req, resp);
    }

}
