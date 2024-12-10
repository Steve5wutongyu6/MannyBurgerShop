package action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", value = "/LogOutServlet")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前会话
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 销毁会话
            session.invalidate();
        }

        // 删除存储在Cookie中的用户名和令牌
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName()) || "token".equals(cookie.getName())) {
                    cookie.setMaxAge(0); // 设置Cookie过期时间为0，立即删除
                    cookie.setPath("/"); // 确保Cookie路径正确
                    response.addCookie(cookie);
                }
            }
        }

        // 重定向到登录页面或其他页面
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
