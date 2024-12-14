package dao;

import bean.Order;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO {

    /**
     * 保存订单信息到数据库
     *
     * @param uid   用户ID
     * @param listid 订单ID
     * @param time  下单时间
     * @param item  商品信息的JSON字符串
     * @throws SQLException 如果发生SQL异常
     */
    public void saveOrder(String uid, String listid, String time, String item) throws SQLException {
        String sql = "INSERT INTO olist (uid, listid, time, item) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uid);
            pstmt.setString(2, listid);
            pstmt.setString(3, time);
            pstmt.setString(4, item);
            pstmt.executeUpdate();
        }
    }
}
