package action;

import bean.Cart;
import service.CartItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RemoveFromCartServlet", value = "/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从url参数中接收pid
        String pid = request.getParameter("pid");
        if (pid == null || pid.isEmpty()) {
            System.out.println("参数缺失");
        }
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        CartItemService.removeCartItem(pid);
        request.getRequestDispatcher("/CartServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
