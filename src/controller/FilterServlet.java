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

public class FilterServlet extends HttpServlet {

    @EJB
    private ProductSessionBean productSessionBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String min = request.getParameter("Min");
        String max = request.getParameter("Max");

        List<Product> ls = productSessionBean.getProductsByPrice(min, max);
        getServletContext().setAttribute("newProducts", ls);
        RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
