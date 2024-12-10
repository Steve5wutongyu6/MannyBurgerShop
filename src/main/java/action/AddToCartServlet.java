package action;

import bean.Cart;
import bean.OrderItems;
import dao.CartDAO;
import dao.OrderItemDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private OrderItemDAO orderItemDAO = new OrderItemDAO();
    private CartDAO cartDAO = new CartDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pidParam = request.getParameter("pid");
        String uid = request.getParameter("uid");

        if (pidParam == null || pidParam.isEmpty() || uid == null || uid.isEmpty()) {
            response.sendRedirect("ProductDetailServlet"); // 如果没有商品ID或用户ID，则重定向到商品详情页
            System.out.println("如果没有商品ID或用户ID，则重定向到商品详情页");
            return;
        }

        int pid = Integer.parseInt(pidParam);
        OrderItems orderItem = orderItemDAO.getOrderItemByUidAndPid(uid, pid);

        if (orderItem == null) {
            // 创建新的订单项
            orderItem = new OrderItems();
            orderItem.setUid(uid);
            orderItem.setPid(pid);
            orderItemDAO.addOrderItem(orderItem);
            System.out.println("AddToCartServlet: " + orderItem);
        }


        // 更新购物车信息
        Cart cart = cartDAO.getCartByUid(uid);
        if (cart == null) {
            cart = new Cart();
            cart.setUid(uid);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            cart.setTime(new Time(timestamp.getTime())); // 进行类型转换
            cartDAO.addCart(cart);
            System.out.println("AddToCartServlet: " + cart);
        }

        response.sendRedirect("SelectItemsInCartServlet"); // 重定向到购物车页面
    }
}
