package action;

import bean.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllProductByPidAndCidServlet", value = "/SelectAllProductByPidAndCidServlet")
public class SelectAllProductByPidAndCidServlet extends HttpServlet {
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cidParam = request.getParameter("cid");
        String pageNoParam = request.getParameter("pageNo");

        int cid = 1; // 默认显示汉堡
        int pageNo = 1; // 默认第一页

        if (cidParam != null && !cidParam.isEmpty()) {
            cid = Integer.parseInt(cidParam);
        }

        if (pageNoParam != null && !pageNoParam.isEmpty()) {
            pageNo = Integer.parseInt(pageNoParam);
        }

        int pageSize = 8; // 每页最多展示8个产品
        List<Product> products = productService.getProductsByCidAndPage(cid, pageNo, pageSize);
        int totalProducts = productService.getTotalProductsByCid(cid);
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        request.setAttribute("products", products);
        request.setAttribute("activeCid", cid);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("/AllProducts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
