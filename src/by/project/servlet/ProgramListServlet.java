package by.project.servlet;

import by.project.service.ProgramService;
import by.project.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/program-list", name = "/ProgramList")
public class ProgramListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("program", ProgramService.getInstance().findAll());
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("program-list"))
                .forward(req,resp);
    }
}