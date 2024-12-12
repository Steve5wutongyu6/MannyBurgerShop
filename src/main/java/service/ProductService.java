package service;

import bean.Product;
import dao.ProductDAO;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

/*    public List<Product> getHotHamburgerProducts() {
        return productDAO.getHotHamburgerProducts();
    }

    public List<Product> getHotChickensProducts() {
        return productDAO.getHotChickensProducts();
    }

    public List<Product> getHotChipsProducts() {
        return productDAO.getHotChipsProducts();
    }

    public List<Product> getHotDrinksProducts() {
        return productDAO.getHotDrinksProducts();
    }*/

    public List<Product> getProductsByCid(int cid) {
        return productDAO.getProductsByCid(cid);
    }

    public Product getProductById(int pid) {
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
                    product.setMarketPrice(rs.getDouble("market_price"));
                    product.setShopPrice(rs.getDouble("shop_price"));
                    product.setPimage(rs.getString("pimage"));
                    product.setPdate(rs.getString("pdate"));
                    product.setIsHot(rs.getInt("is_hot"));
                    product.setPdesc(rs.getString("pdesc"));
                    product.setPflag(rs.getInt("pflag"));
                    product.setCid(rs.getString("cid"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> getProductsByCidAndPage(int cid, int pageNo, int pageSize) {
        return productDAO.getProductsByCidAndPage(cid, pageNo, pageSize);
    }

    public int getTotalProductsByCid(int cid) {
        return productDAO.getTotalProductsByCid(cid);
    }
}