package controller;

import model.Product;
import session_bean.CategorySessionBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {
    @EJB
    private CategorySessionBean categorySessionBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        if (userPath.equals("/category")) {
            String categoryId = request.getParameter("id");
            if (categoryId != null) {
                List<Product> categoryProducts = categorySessionBean.getCategoryProduct(Integer.parseInt(categoryId));
                session.setAttribute("newProducts", categoryProducts);
                try {
                    RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
                    rd.forward(request, response);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
