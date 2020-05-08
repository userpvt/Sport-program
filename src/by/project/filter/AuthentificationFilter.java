package by.project.filter;

import by.project.entity.User;
import by.project.util.MappingConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter("/*")
public class AuthentificationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (isLoginPage(servletRequest) || isChangeLanguage(servletRequest) || isUserAuthorized(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("/login");
        }
    }

    private boolean isChangeLanguage(ServletRequest servletRequest) {
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        return MappingConst.CHANGE_LOCALE.equals(requestURI);
    }

    private boolean isUserAuthorized(ServletRequest servletRequest) {
        User user = (User) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return Objects.nonNull(user);
    }

    public boolean isLoginPage(ServletRequest servletRequest) {
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        return MappingConst.LOGIN_PAGE.equals(requestURI);
    }
}