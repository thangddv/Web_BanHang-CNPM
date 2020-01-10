package controller;

import model.Cart;
import model.CartItem;
import model.Product;
import session_bean.ProductSessionBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveItemServlet extends HttpServlet {

    @EJB
    ProductSessionBean productSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                return;
            }
            int product_id = Integer.parseInt(request.getParameter("product_id"));
            List<CartItem> items = cart.getItems();
            items = items.stream().filter(item -> item.getProduct().getProductId() != product_id).collect(Collectors.toList());
            cart.setItems(items);
            cart.setTotal();
            RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}
