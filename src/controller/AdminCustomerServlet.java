package controller;


import model.Customer;
import session_bean.CustomerSessionBean;

import javax.ejb.EJB;
import javax.ejb.SessionBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class AdminCustomerServlet extends HttpServlet {
    @EJB
    private CustomerSessionBean customerSessionBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> ls = customerSessionBean.getAllCustomers();
        getServletContext().setAttribute("listCustomers", ls);
        RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
