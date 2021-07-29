package by.htp.task.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {
    public static final String CHARACTER_ENCODING = "characterEncoding";

    private String encoding;
    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        encoding = fConfig.getInitParameter(CHARACTER_ENCODING);
        context = fConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        context.log("Charset was set.");

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}


