package service;

import bean.CartItem;
import bean.Product;
import bean.User;
import dao.CartItemDAO;
import utils.UUIDUtils;

import java.sql.SQLException;

public class CartItemService {
    private final CartItemDAO cartItemDAO = new CartItemDAO();

    public static void removeCartItem(String pid) {
        CartItemDAO.removeCartItem(pid);
    }

    public void addToCart(User user, Product product, int count) throws SQLException {
        String uid = user.getUid();
        String oid = cartItemDAO.findOrCreateOrderIdByUid(uid); // 查找或创建订单ID
        CartItem cartItem = cartItemDAO.findCartItemByUidAndPid(uid, product.getPid());

        if (cartItem != null) {
            cartItem.setCount(cartItem.getCount() + count);
            cartItem.setSubtotal(cartItem.getSubtotal() + product.getShopPrice() * count);
            System.out.println("购物车已有该商品，数量增加" + count);
        } else {
            cartItem = new CartItem(UUIDUtils.getId(), count, product.getShopPrice() * count, product, oid);
        }

        cartItemDAO.addOrUpdateCartItem(cartItem);
    }
}
