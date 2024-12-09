package action;

import bean.User;
import dao.UserDao;
import utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String sex = request.getParameter("sex");
        String birthdayStr = request.getParameter("birthday");

        // 处理日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = sdf.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 创建 User 对象
        User user = new User();
        user.setUid(UUIDUtils.getId());
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setState(1); // 默认状态为1

        // 调用 UserDao 进行保存
        UserDao userDao = new UserDao();
        boolean result = userDao.save(user);

        if (result) {
            response.sendRedirect("login.jsp"); // 注册成功后跳转到登录页面
        } else {
            request.setAttribute("message", "注册失败，请重试！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
