package dao;

import bean.Olist;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OlistDAO {
    /**
     * 查询所有的订单记录
     *
     * @return 订单列表
     * @throws SQLException 如果发生SQL异常
     */
    public List<Olist> getAllOrders() throws SQLException {
        List<Olist> olists = new ArrayList<>();
        String sql = "SELECT * FROM olist";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Olist olist = new Olist();
                olist.setListid(rs.getString("listid"));
                olist.setUid(rs.getString("uid"));
                olist.setTime(rs.getString("time"));
                olist.setItem(rs.getString("item"));
                olists.add(olist);
            }
        }
        return olists;
    }
}
