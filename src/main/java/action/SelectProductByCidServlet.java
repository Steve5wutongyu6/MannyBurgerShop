package action;

import bean.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectProductByCidServlet", value = "/SelectProductByCidServlet")
public class SelectProductByCidServlet extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cidParam = request.getParameter("cid");
        if (cidParam == null || cidParam.isEmpty()) {
            cidParam = "1"; // 默认显示汉堡
        }
        int cid = Integer.parseInt(cidParam);
        List<Product> hotProducts = productService.getProductsByCid(cid);
        request.setAttribute("hotProducts", hotProducts);
        request.setAttribute("activeCid", cid); // 设置当前激活的cid
        request.getRequestDispatcher("/hot.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
