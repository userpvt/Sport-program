package by.project.servlet;

import by.project.entity.Category;
import by.project.service.CategoryService;
import by.project.util.JspPathUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = CategoryService.getInstance().findAll();
        req.setAttribute("categories",categories);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("categories"))
                .forward(req,resp);
    }
}