package action;

import bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MenuServlet", value = "/MenuServlet")
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("user: " + user);
        if (user != null) {
            request.setAttribute("username", user.getUsername());
            // 调用ImageServlet将绝对路径转换为相对路径
            String absolutePath = user.getPhoto_path();
            String relativePath = request.getContextPath() + "/ImageServlet?path=" + absolutePath;
            request.setAttribute("photoPath", relativePath);
        }
        request.getRequestDispatcher("/menu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
