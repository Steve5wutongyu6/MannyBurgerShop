package action;

import bean.User;
import utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;
        String token = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                } else if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }

        if (username != null && token != null) {
            // 在实际应用中，应验证token的安全性
            User user = new User();
            user.setUsername(username);

            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                conn = DBUtil.getConnection();
                String sql = "SELECT * FROM user WHERE username=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    HttpSession session = request.getSession();
                    user.setUid(rs.getString("uid"));
                    user.setPassword(rs.getString("password"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setTelephone(rs.getString("telephone"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setSex(rs.getString("sex"));
                    user.setState(rs.getInt("state"));
                    System.out.println("user: " + user);

                    session.setAttribute("user", user);
                    response.sendRedirect("ProductListServlet");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(conn, pstmt, rs);
            }
        }

        // 如果没有有效的Cookie，则重定向到登录页面
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            System.out.println(pstmt);

            if (rs.next()) {
                // 登录成功
                HttpSession session = request.getSession();
                User user = new User();
                user.setUid(rs.getString("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setTelephone(rs.getString("telephone"));
                user.setBirthday(rs.getDate("birthday"));
                user.setSex(rs.getString("sex"));
                user.setState(rs.getInt("state"));
                user.setPhoto_path(rs.getString("photo_path"));
                System.out.println("user: " + user);

                session.setAttribute("user", user);

                // 创建cookie
                Cookie usernameCookie = new Cookie("username", user.getUsername());
                usernameCookie.setMaxAge(30 * 60); // 设置Cookie过期时间为30分钟
                System.out.println("usernameCookie: " + usernameCookie);
                response.addCookie(usernameCookie);


                Cookie tokenCookie = new Cookie("token", user.getUsername()); // 登陆令牌
                tokenCookie.setMaxAge(30 * 60);
                System.out.println("tokenCookie: " + tokenCookie);
                response.addCookie(tokenCookie);

                response.sendRedirect("MenuServlet");
                System.out.println("登录成功" + "重定向到MenuServlet");
            } else {
                // 登录失败
                request.setAttribute("message", "Invalid username or password.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pstmt, rs);
        }
    }
}
