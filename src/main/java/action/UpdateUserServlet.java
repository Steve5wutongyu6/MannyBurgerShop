package action;


import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String birthdayStr = request.getParameter("birthday");
        String sex = request.getParameter("sex");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = sdf.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setBirthday(birthday);
        user.setSex(sex);

        UserDao userDao = new UserDao();
        boolean isUpdated = userDao.updateUser(user);

        if (isUpdated) {
            request.setAttribute("message", "用户信息更新成功！");
            System.out.println("用户信息更新成功！");
            request.getRequestDispatcher("/updateuser.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "用户信息更新失败！");
            System.out.println("用户信息更新失败！");
            request.getRequestDispatcher("/updateuser.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        UserDao userDao = new UserDao();
        User user = userDao.selectUserByName(new User());
        request.setAttribute("user", user);
        request.getRequestDispatcher("/updateuser.jsp").forward(request, response);
    }
}
