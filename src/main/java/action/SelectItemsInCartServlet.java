package action;

import bean.OrderItems;
import bean.Product;
import dao.OrderItemDAO;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectItemsInCartServlet", value = "/SelectItemsInCartServlet")
public class SelectItemsInCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");

        if (uid == null || uid.isEmpty()) {
            response.sendRedirect("ProductDetailServlet"); // 如果没有用户ID，则重定向到商品详情页
            return;
        }

        List<OrderItems> orderItemsList = OrderItemDAO.getOrderItemsByUid(uid);
        List<Product> productList = new ArrayList<>();
        double totalPrice = 0;

        for (OrderItems orderItem : orderItemsList) {
            Product product = ProductDAO.getProductById(orderItem.getPid());
            productList.add(product);
            totalPrice += product.getShopPrice();
            System.out.println(product.getPname() + " " + product.getShopPrice() + " " + totalPrice);
        }

        request.setAttribute("orderItemsList", orderItemsList);
        request.setAttribute("productList", productList);
        request.setAttribute("totalPrice", totalPrice);
        System.out.println("SelectItemsInCartServlet" + productList + "totalPrice" + totalPrice + "orderItemsList" + orderItemsList + " ");

        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
