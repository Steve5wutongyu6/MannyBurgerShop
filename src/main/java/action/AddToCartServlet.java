package action;

import bean.Product;
import bean.User;
import service.CartItemService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final CartItemService cartItemService = new CartItemService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pidParam = request.getParameter("pid");
        String uidParam = request.getParameter("uid");
        String countParam = request.getParameter("count");
        System.out.println("AddToCartServlet获取到的参数" + "pidParam" + pidParam + "uidParam" + uidParam + "countParam" + countParam);

        if (pidParam == null || uidParam == null || countParam == null) {
            response.sendRedirect("SelectProductByCidServlet"); // 参数不完整，重定向到首页
            System.out.println("参数不完整");
            return;
        }

        int pid = Integer.parseInt(pidParam);
        int count = Integer.parseInt(countParam);
        User user = (User) request.getSession().getAttribute("user"); // 获取用户对象

        if (user == null || !user.getUid().equals(uidParam)) {
            response.sendRedirect("SelectProductByCidServlet");// 用户未登录或UID不匹配，重定向到首页
            System.out.println("用户未登录或UID不匹配");
            return;
        }

        Product product = productService.getProductById(pid);
        if (product == null) {
            response.sendRedirect("SelectProductByCidServlet"); // 商品不存在，重定向到首页
            System.out.println("商品不存在");
            return;
        }

        try {
            cartItemService.addToCart(user, product, count);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("SelectProductByCidServlet"); // 发生错误，重定向到首页
            System.out.println("发生错误SQLException");
            return;
        }

        System.out.println("添加购物车成功");
        response.sendRedirect("SelectAllProductByPidAndCidServlet"); // 成功添加到购物车，重定向到菜单页面
    }
}