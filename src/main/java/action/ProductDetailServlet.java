package action;

import bean.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductDetailServlet", value = "/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pidParam = request.getParameter("pid");
        if (pidParam == null || pidParam.isEmpty()) {
            response.sendRedirect("SelectProductByCidServlet"); // 如果没有商品ID，则重定向到首页
            return;
        }
        int pid = Integer.parseInt(pidParam);
        Product product = productService.getProductById(pid);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/productDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
