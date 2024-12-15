package dao;

import bean.CartItem;
import bean.Product;
import utils.DBUtil;
import utils.UUIDUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartItemDAO {
    public static void removeCartItem(String pid) {
        String sql = "DELETE FROM cartitem WHERE pid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pid);
            System.out.println(pstmt.toString()); // 打印SQL语句
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 插入或更新购物车项
    public void addOrUpdateCartItem(CartItem cartItem) throws SQLException {
        String sql = "INSERT INTO cartitem (itemid, count, subtotal, pid, oid) VALUES (?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE count = count + ?, subtotal = subtotal + ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cartItem.getItemid());
            pstmt.setInt(2, cartItem.getCount());
            pstmt.setDouble(3, cartItem.getSubtotal());
            pstmt.setInt(4, cartItem.getProduct().getPid());
            pstmt.setString(5, cartItem.getOid());
            pstmt.setInt(6, cartItem.getCount());
            pstmt.setDouble(7, cartItem.getSubtotal());

            System.out.println(pstmt.toString()); // 打印SQL语句
            pstmt.executeUpdate();
        }
    }

    // 根据用户ID和产品ID查找购物车项
    public CartItem findCartItemByUidAndPid(String uid, int pid) throws SQLException {
        String sql = "SELECT * FROM cartitem WHERE oid = ? AND pid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, uid);
            pstmt.setInt(2, pid);

            System.out.println(pstmt.toString()); // 打印SQL语句
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                CartItem cartItem = new CartItem();
                cartItem.setItemid(rs.getString("itemid"));
                cartItem.setCount(rs.getInt("count"));
                cartItem.setSubtotal(rs.getDouble("subtotal"));
                Product product = new Product();
                product.setPid(rs.getInt("pid"));
                cartItem.setProduct(product);
                cartItem.setOid(rs.getString("oid"));
                return cartItem;
            }
        }
        return null;
    }

    // 查找或创建订单ID
    public String findOrCreateOrderIdByUid(String uid) throws SQLException {
        String sqlFind = "SELECT oid FROM cart WHERE uid = ? AND state = 0";
        String sqlInsert = "INSERT INTO cart (oid, ordertime, total, state, uid) VALUES (?, NOW(), 0, 0, ?)";
        String oid = UUIDUtils.getId();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmtFind = conn.prepareStatement(sqlFind);
             PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert)) {

            pstmtFind.setString(1, uid);
            System.out.println(pstmtFind.toString()); // 打印SQL语句
            ResultSet rs = pstmtFind.executeQuery();
            if (rs.next()) {
                return rs.getString("oid");
            } else {
                pstmtInsert.setString(1, oid);
                pstmtInsert.setString(2, uid);
                System.out.println(pstmtInsert.toString()); // 打印SQL语句
                pstmtInsert.executeUpdate();
                return oid;
            }
        }
    }

    // 根据用户ID查找所有购物车项
    public List<CartItem> findCartItemsByUid(String uid) throws SQLException {
        String sql = "SELECT * FROM cartitem WHERE oid IN (SELECT oid FROM cart WHERE uid = ?)";
        List<CartItem> cartItems = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, uid);

            System.out.println(pstmt.toString()); // 打印SQL语句
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CartItem cartItem = new CartItem();
                cartItem.setItemid(rs.getString("itemid"));
                cartItem.setCount(rs.getInt("count"));
                cartItem.setSubtotal(rs.getDouble("subtotal"));
                Product product = new Product();
                product.setPid(rs.getInt("pid"));
                cartItem.setProduct(product);
                cartItem.setOid(rs.getString("oid"));
                cartItems.add(cartItem);
            }
        }
        return cartItems;
    }

    public void clearCartByUid(String uid) {
        // 清空购物车（清空给定uid的cart和cartitem）
        String sqlGetOids = "SELECT oid FROM cart WHERE uid = ?";
        String sqlDeleteCart = "DELETE FROM cart WHERE uid = ?";
        String sqlDeleteCartItems = "DELETE FROM cartitem WHERE oid = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmtGetOids = conn.prepareStatement(sqlGetOids);
             PreparedStatement pstmtDeleteCart = conn.prepareStatement(sqlDeleteCart);
             PreparedStatement pstmtDeleteCartItems = conn.prepareStatement(sqlDeleteCartItems)) {

            // 获取所有与uid对应的oid
            pstmtGetOids.setString(1, uid);
            ResultSet rs = pstmtGetOids.executeQuery();

            // 删除cartitem表中对应的oid项
            while (rs.next()) {
                String oid = rs.getString("oid");
                pstmtDeleteCartItems.setString(1, oid);
                pstmtDeleteCartItems.executeUpdate();
            }

            // 删除cart表中对应的uid项
            pstmtDeleteCart.setString(1, uid);
            pstmtDeleteCart.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
