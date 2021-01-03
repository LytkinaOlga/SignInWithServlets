package by.bntu.fitr.poisit.lytkina.servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthorizedFilter implements Filter  {
    private FilterConfig fc;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Boolean isAuthorized = (Boolean)req.getSession().getAttribute("isAuthorized");
        if (isAuthorized!=null && isAuthorized == true){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            RequestDispatcher view = req.getRequestDispatcher("/index");
            view.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
