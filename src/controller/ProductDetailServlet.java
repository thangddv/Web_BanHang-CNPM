package controller;
import session_bean.ProductDetailSessionBean;
import session_bean.ProductSessionBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductDetailServlet extends HttpServlet{
    @EJB
    private ProductSessionBean productSessionBean;

    @EJB
    private ProductDetailSessionBean productDetailSessionBean;

    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //lay product_id tu parameter url /productdetail?product_id=id0001
        String product_id = request.getParameter("product_id");

        getServletContext().setAttribute("thisProduct", productSessionBean.getProduct(product_id));
        getServletContext().setAttribute("thisProductDetail", productDetailSessionBean.getDetailProduct(product_id));
        request.getRequestDispatcher("product-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
