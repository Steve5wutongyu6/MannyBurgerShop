package action;

import bean.Olist;
import dao.OlistDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AllOrderServlet", value = "/AllOrderServlet")
public class AllOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OlistDAO olistDAO = new OlistDAO();
        try {
            List<Olist> olist = olistDAO.getAllOrders();
            request.setAttribute("olist", olist);
            request.getRequestDispatcher("allorders.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务器错误");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
