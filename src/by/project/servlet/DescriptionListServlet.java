package by.project.servlet;

import by.project.service.DescriptionService;
import by.project.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/description-list", name = "/DescriptionList")
public class DescriptionListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("description", DescriptionService.getInstance().findAll());
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("description-list"))
                .forward(req,resp);
    }
}