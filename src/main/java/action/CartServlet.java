package servlet;

import bean.CartItem;
import bean.Product;
import bean.User;
import dao.CartItemDAO;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String uid = user.getUid();

        CartItemDAO cartItemDAO = new CartItemDAO();
        ProductDAO productDAO = new ProductDAO();

        try {
            List<CartItem> cartItems = cartItemDAO.findCartItemsByUid(uid);
            List<Product> products = new ArrayList<>();

            double totalPrice = 0;
            for (CartItem cartItem : cartItems) {
                Product product = productDAO.getProductById(cartItem.getProduct().getPid());
                cartItem.setProduct(product);
                products.add(product);
                totalPrice += cartItem.getSubtotal();
            }

            //request.setAttribute("cartItems", cartItems);
            request.setAttribute("productList", products);
            request.setAttribute("totalPrice", totalPrice);

            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务器错误");
        }
    }
}
