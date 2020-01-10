package controller;

import model.*;
import session_bean.OrderProductSessionBean;
import session_bean.OrderSessionBean;

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

public class OrderServlet extends HttpServlet {

    @EJB
    OrderSessionBean orderSessionBean;

    @EJB
    OrderProductSessionBean orderProductSessionBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            String phone_no = (String) session.getAttribute("phone_no");
            Customer customer = (Customer) session.getAttribute("customer");
            if (phone_no == null || phone_no == "") phone_no = "12345687";
            CustomerOrder customerOrder = new CustomerOrder();
            customerOrder.setAmount(cart.getTotal());
            customerOrder.setConfirmationNumber(customer.getPhone());
            customerOrder.setCustomerId(customer.getCustomerId());
            orderSessionBean.create(customerOrder);
            customerOrder = orderSessionBean.getLastOrder();
            List<CartItem> list = cart.getItems();
            List<OrderedProduct> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                OrderedProduct item = new OrderedProduct(customerOrder.getOrderId(), list.get(i).getProduct().getProductId(),
                         list.get(i).getQuantity());
                list1.add(item);
            }
            list1.forEach(item -> orderProductSessionBean.create(item));
            session.setAttribute("cart", null);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Ordered successfully. Thanks you and see you again!!!');");
            out.println("console.log('Ordered successfully. Thanks you and see you again!!!');");
            out.println("location='index.jsp';");
            out.println("</script>");

        } catch (Exception e) {
            System.out.println(e);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Ordered failed. Please login!!!');");
            out.println("location='login.jsp';");
            out.println("</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        try {
//            HttpSession session = request.getSession();
//            Cart cart = (Cart) session.getAttribute("cart");
//            System.out.println("222222222222222222222");
//            System.out.println(cart.getItems());
//            CustomerOrder customerOrder = new CustomerOrder();
//            customerOrder.setAmount(cart.getTotal());
//            customerOrder.setConfirmationNumber("0369788432");
//            customerOrder.setCustomerId(2);
////            List<CartItem> list = cart.getItems();
////            List<OrderedProduct> list1 = new ArrayList<>();
////            for (int i = 0; i < list.size(); i++) {
////                OrderedProduct item = new OrderedProduct(list.get(i).getProduct().getProductId(),
////                         list.get(i).getQuantity());
////                list1.add(item);
////            }
////            customerOrder.setOrderedProductsByOrderId(list1);
//            orderSessionBean.create(customerOrder);
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Ordered product successful');");
//            out.println("</script>");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

}
