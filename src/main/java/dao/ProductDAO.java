package dao;

import bean.Product;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

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
/*
    // 热门汉堡
    public List<Product> getHotHamburgerProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from product where is_hot=1 and cid=1 limit 4";
        return getProducts(productList, sql);
    }

    // 热门鸡
    public List<Product> getHotChickensProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from product where is_hot=1 and cid=2 limit 4";
        return getProducts(productList, sql);
    }

    // 热门薯条
    public List<Product> getHotChipsProducts() {
        List<Product> productsList = new ArrayList<>();
        String sql = "select * from product where is_hot=1 and cid=3 limit 4";
        return getProducts(productsList, sql);
    }

    // 热门饮料
    public List<Product> getHotDrinksProducts() {
        List<Product> productsList = new ArrayList<>();
        String sql = "select * from product where is_hot=1 and cid=4 limit 4";
        return getProducts(productsList, sql);
    }*/

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



}
