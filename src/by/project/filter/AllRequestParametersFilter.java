package by.project.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebFilter("/*")
public class AllRequestParametersFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Map<String, String[]> parameterMap = servletRequest.getParameterMap();
        parameterMap.forEach((key, value) -> System.out.println(key + ": " + Arrays.toString(value)));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}