package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化操作
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String requestURI = httpRequest.getRequestURI();

        // 允许访问的URL列表
        String[] allowedURIs = {"/login.jsp", "/LoginServlet", "/register.jsp", "/register", "/updateuser.jsp", "/UpdateUserServlet", "/LogOutServlet", "/error.jsp","/css/*"};

        boolean allowedRequest = false;
        for (String uri : allowedURIs) {
            if (requestURI.endsWith(uri)) {
                allowedRequest = true;
                break;
            }
        }

        if (session == null || session.getAttribute("user") == null) {
            if (!allowedRequest) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 销毁操作
    }
}
