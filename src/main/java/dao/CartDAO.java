package dao;

import bean.Cart;
import utils.DBUtil;

import java.sql.*;

public class CartDAO {
    public void addCart(Cart cart) {
        String sql = "INSERT INTO cart (uid,oid,time) VALUES (?,?,?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cart.getUid());
            pstmt.setInt(2, cart.getOid());
            // 转换 Time 到 Timestamp
            java.sql.Time time = cart.getTime();
            Timestamp timestamp = new Timestamp(time.getTime());
            pstmt.setTimestamp(3, timestamp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql1 = "INSERT INTO orderItem (oid,uid,pid) VALUES (?,?,?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql1)) {
            pstmt.setString(2, cart.getUid());
            pstmt.setInt(1, cart.getOid());
            pstmt.setInt(3, cart.getPid());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Cart getCartByUid(String uid) {
        Cart cart = null;
        String sql = "SELECT * FROM cart WHERE uid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uid);
            System.out.println(pstmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cart = new Cart();
                    cart.setCid(rs.getInt("cid"));
                    cart.setUid(rs.getString("uid"));
                    java.sql.Time time = new java.sql.Time(rs.getTimestamp("time").getTime());
                    cart.setTime(time);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }
}

