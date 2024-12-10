package dao;

import bean.OrderItems;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAO {
    public static List<OrderItems> getOrderItemsByUid(String uid) {
        List<OrderItems> orderItemsList = new ArrayList<>();
        String sql = "SELECT * FROM orderitem WHERE uid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uid);
            System.out.println(pstmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    OrderItems orderItem = new OrderItems();
                    orderItem.setOid(rs.getInt("oid"));
                    orderItem.setUid(rs.getString("uid"));
                    orderItem.setPid(rs.getInt("pid"));
                    orderItemsList.add(orderItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItemsList;
    }

    public void addOrderItem(OrderItems orderItem) {
        String sql = "INSERT INTO orderitem (uid, pid) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, orderItem.getUid());
            pstmt.setInt(2, orderItem.getPid());
            System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public OrderItems getOrderItemByUidAndPid(String uid, int pid) {
        OrderItems orderItem = null;
        String sql = "SELECT * FROM orderitem WHERE uid = ? AND pid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uid);
            pstmt.setInt(2, pid);
            System.out.println(pstmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    orderItem = new OrderItems();
                    orderItem.setOid(rs.getInt("oid"));
                    orderItem.setUid(rs.getString("uid"));
                    orderItem.setPid(rs.getInt("pid"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }
}
