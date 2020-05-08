package by.project.servlet;

import by.project.dto.ViewProgramFullInfoDto;
import by.project.service.ProgramService;
import by.project.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/program-info")
public class FullInfoProgramServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String programId = req.getParameter("id");
        ViewProgramFullInfoDto program = ProgramService.getInstance().findById(Long.valueOf(programId));
        req.setAttribute("program",program);

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("program-info"))
                .forward(req,resp);
    }
}