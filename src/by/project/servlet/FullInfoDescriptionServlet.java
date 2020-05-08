package by.project.servlet;

import by.project.dto.ViewDescriptionFullInfoDto;
import by.project.dto.ViewProgramFullInfoDto;
import by.project.service.DescriptionService;
import by.project.service.ProgramService;
import by.project.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/description-info")
public class FullInfoDescriptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String descriptionId = req.getParameter("id");
        ViewDescriptionFullInfoDto description = DescriptionService.getInstance().findById(Long.valueOf(descriptionId));
        req.setAttribute("description",description);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("description-info"))
                .forward(req,resp);
    }
}