package controller;

import model.Cart;
import model.Product;
import session_bean.ProductSessionBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CartAddServlet extends HttpServlet {
    @EJB
    ProductSessionBean productSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            String product_id = request.getParameter("product_id");
            if (product_id != null) {
                Product product = productSessionBean.getProduct(product_id);
                cart.addItem(product);
                cart.setTotal();
                RequestDispatcher rd = request.getRequestDispatcher("");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}
