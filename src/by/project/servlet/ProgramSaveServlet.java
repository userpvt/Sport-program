package by.project.servlet;

import by.project.dto.CreateNewProgramDto;
import by.project.dto.ViewProgramBasicInfoDto;
import by.project.entity.Gender;
import by.project.entity.Level;
import by.project.entity.Period;
import by.project.service.CategoryService;
import by.project.service.ProgramService;
import by.project.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/program-save")
public class ProgramSaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", CategoryService.getInstance().findAll());
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("program-save"))
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewProgramDto programDto = CreateNewProgramDto.builder()
                .name(req.getParameter("name"))
                .author(req.getParameter("author"))
                .days(Integer.valueOf(req.getParameter("days")))
                .gender(Gender.valueOf(req.getParameter("gender")))
                .level(Level.valueOf(req.getParameter("level")))
                .period(Period.valueOf(req.getParameter("period")))
                .categoryId(Integer.valueOf(req.getParameter("category")))
                .build();
        ViewProgramBasicInfoDto savedPerson = ProgramService.getInstance().save(programDto);
        resp.sendRedirect("/program-info?id=" + savedPerson.getId());
    }
}