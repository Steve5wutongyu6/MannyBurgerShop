package dao;

import bean.User;
import utils.DBUtil;

import java.sql.*;

public class UserDao {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    User findu = null;

    // 通过用户名查询用户信息，并返回用户信息findu，findu为User类型
    public User selectUserByName(User u) {
        try {
            conn = DBUtil.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user WHERE username='" + u.getUsername() + "'";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String uid = rs.getString("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                Date birthday = rs.getDate("birthday");
                String telephone = rs.getString("telephone");
                String photo_path = rs.getString("photo_path");
                findu = new User();
                findu.setUid(uid);
                findu.setUsername(username);
                findu.setPassword(password);
                findu.setEmail(email);
                findu.setName(name);
                findu.setSex(sex);
                findu.setBirthday(birthday);
                findu.setTelephone(telephone);
                findu.setPhoto_path(photo_path);
                System.out.println("findu:" + findu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, stmt, rs);
        }
        return findu;
    }

    // 定义一个res用于确定是否添加用户成功，0表示未添加成功
    // date要进行转型，不然会出错
    //除了dao层，其他层的Date导入的都是util的包,到层导sql的包

    public boolean save(User user) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO user(uid, username, password, name, email, telephone, sex, birthday, state, photo_path) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUid());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getTelephone());
            ps.setString(7, user.getSex());
            ps.setDate(8, new java.sql.Date(user.getBirthday().getTime()));
            ps.setInt(9, user.getState());
            ps.setString(10, user.getPhoto_path());
            System.out.println("插入新用户数据：" + ps);
            int rows = ps.executeUpdate();

            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return false;
    }

    // 更新用户信息的方法
    public boolean updateUser(User user) {
        String sql = "UPDATE user SET name = ?, password = ?, email = ?, telephone = ?, birthday = ?, sex = ?, photo_path = ? WHERE username = ?";

        try {
            Connection conn = DBUtil.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getTelephone());
            pstmt.setDate(5, new Date(user.getBirthday().getTime()));
            pstmt.setString(6, user.getSex());
            pstmt.setString(7, user.getPhoto_path());
            pstmt.setString(8, user.getUsername());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("更新行数: " + rowsAffected + pstmt);
            return rowsAffected > 0; // 返回是否更新成功
        } catch (SQLException e) {
            System.out.println("SQL 异常: " + e.getMessage());
            e.printStackTrace();
            return false; // 更新失败
        } catch (Exception e) {
            System.out.println("其他异常: " + e.getMessage());
            e.printStackTrace();
            return false; // 更新失败
        }
    }


}
