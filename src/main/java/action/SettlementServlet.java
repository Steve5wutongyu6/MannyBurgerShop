package action;

import bean.CartItem;
import bean.Product;
import bean.User;
import dao.CartItemDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import utils.JsonUtil;
import utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SettlementServlet", value = "/SettlementServlet")
public class SettlementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp"); // 如果用户未登录，重定向到登录页面
            return;
        }

        String uid = user.getUid();

        CartItemDAO cartItemDAO = new CartItemDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();

        try {
            List<CartItem> cartItems = cartItemDAO.findCartItemsByUid(uid);
            List<Product> products = new ArrayList<>();

            for (CartItem cartItem : cartItems) {
                Product product = productDAO.getProductById(cartItem.getProduct().getPid());
                cartItem.setProduct(product);
                products.add(product);
            }

            // 将商品列表转换为JSON格式
            String item = JsonUtil.toJson(products);

            // 生成订单ID
            String listid = UUIDUtils.getCode();

            // 获取当前时间
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = now.format(formatter);

            // 保存订单信息到数据库
            orderDAO.saveOrder(uid, listid, time, item);

            // 清空购物车（可选）
            cartItemDAO.clearCartByUid(uid);

            // 将listid传递到ofinish.jsp
            request.setAttribute("listid", listid);

            // 转发到ofinish.jsp
            request.getRequestDispatcher("ofinish.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务器错误");
        }
    }
}
