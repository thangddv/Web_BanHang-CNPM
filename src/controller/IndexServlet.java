package controller;

import model.Product;
import session_bean.ProductSessionBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {
    @EJB
    private ProductSessionBean productSessionBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> ls = productSessionBean.getTopProducts();
        getServletContext().setAttribute("newProducts", ls);
        List<Product> ls_1 = productSessionBean.getSellerProducts();
        getServletContext().setAttribute("newProducts", ls);
        getServletContext().setAttribute("newProducts_1", ls_1);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
