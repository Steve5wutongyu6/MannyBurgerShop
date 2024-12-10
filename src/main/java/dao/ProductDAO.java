package dao;

import bean.Product;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static Product getProductById(int pid) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE pid=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    product = new Product();
                    product.setPid(rs.getInt("pid"));
                    product.setPname(rs.getString("pname"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    // 获取所有商品
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product";
        return getProducts(productList, sql);
    }

    public List<Product> getProductsByCid(int cid) {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from product where is_hot=1 and cid=? limit 4";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cid);
            System.out.println(pstmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setPid(rs.getInt("pid"));
                    product.setPname(rs.getString("pname"));
                    product.setMarketPrice(rs.getDouble("market_price"));
                    product.setShopPrice(rs.getDouble("shop_price"));
                    product.setPimage(rs.getString("pimage"));
                    product.setPdate(rs.getString("pdate"));
                    product.setIsHot(rs.getInt("is_hot"));
                    product.setPdesc(rs.getString("pdesc"));
                    product.setPflag(rs.getInt("pflag"));
                    product.setCid(rs.getString("cid"));

                    productList.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    // 获取商品详情
    private List<Product> getProducts(List<Product> productList, String sql) {
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product();
                product.setPid(rs.getInt("pid"));
                product.setPname(rs.getString("pname"));
                product.setMarketPrice(rs.getDouble("market_price"));
                product.setShopPrice(rs.getDouble("shop_price"));
                product.setPimage(rs.getString("pimage"));
                product.setPdate(rs.getString("pdate"));
                product.setIsHot(rs.getInt("is_hot"));
                product.setPdesc(rs.getString("pdesc"));
                product.setPflag(rs.getInt("pflag"));
                product.setCid(rs.getString("cid"));

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }


    public List<Product> getProductsByCidAndPage(int cid, int pageNo, int pageSize) {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from product where cid=? limit ? offset ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cid);
            pstmt.setInt(2, pageSize);
            pstmt.setInt(3, (pageNo - 1) * pageSize);
            System.out.println(pstmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setPid(rs.getInt("pid"));
                    product.setPname(rs.getString("pname"));
                    product.setMarketPrice(rs.getDouble("market_price"));
                    product.setShopPrice(rs.getDouble("shop_price"));
                    product.setPimage(rs.getString("pimage"));
                    product.setPdate(rs.getString("pdate"));
                    product.setIsHot(rs.getInt("is_hot"));
                    product.setPdesc(rs.getString("pdesc"));
                    product.setPflag(rs.getInt("pflag"));
                    product.setCid(rs.getString("cid"));

                    productList.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public int getTotalProductsByCid(int cid) {
        int count = 0;
        String sql = "select count(*) as total from product where cid=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cid);
            System.out.println(pstmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
