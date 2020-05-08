package by.project.servlet;

import by.project.dto.LoginDto;
import by.project.entity.User;
import by.project.service.LoginService;
import by.project.util.JspPathUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            getServletContext()
                    .getRequestDispatcher(JspPathUtil.get("login"))
                    .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> user = LoginService.login(new LoginDto(username, password));
        if (user.isPresent()) {
            req.getSession().setAttribute("user", user.get());
            resp.sendRedirect("/start");
        } else {
            //resp.sendRedirect("/login");
            resp.sendRedirect("/login?username=" + (username != null ? username : ""));
        }
    }
}