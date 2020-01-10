package controller;

import model.Customer;
import session_bean.CustomerSessionBean;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerServlet extends HttpServlet {

    @EJB
    private CustomerSessionBean customerSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String command = request.getParameter("command");
        String url = "";
        Customer customer = new Customer();
        HttpSession session = request.getSession();

        switch(command){
            case "insert":
                customer.setName(request.getParameter("Name"));
                customer.setAccount(request.getParameter("Account"));
                customer.setPassword(request.getParameter("Password"));
                customer.setEmail(request.getParameter("Email"));
                customer.setPhone(request.getParameter("Phone"));
                customer.setAddress(request.getParameter("Address"));
                customer.setCityRegion(request.getParameter("CityRegion"));
                customer.setCcNumber(request.getParameter("CcNumber"));
                customer.setRole(0);
                customerSessionBean.create(customer);
//                session.setAttribute("customer", customer);
                url = "login.jsp";
                break;
            case "login":
                customer = customerSessionBean.findCustomer(request.getParameter("Account"), request.getParameter("Password"));
                //customer = customerSessionBean.findCustomer("123", "123");
                if (customer != null){
                    if (customer.getRole() == 0) {
                        session.setAttribute("customer", customer);
                        url = "index.jsp";
                    }else{
                        url = "admin.jsp";
                    }

                }else{
                    request.setAttribute("error", "The account or password is incorrect.");
                    url = "login.jsp";
                }
                break;
        }
//        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
//        rd.forward(request, response);
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
