package controller;
import model.Product;
import model.ProductDetail;
import session_bean.ProductDetailSessionBean;
import session_bean.ProductSessionBean;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertServlet extends HttpServlet {
    @EJB
    ProductSessionBean productSessionBean;

    @EJB
    ProductDetailSessionBean productDetailSessionBean;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("insert.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html");
//
//        PrintWriter out = response.getWriter();
//        String title = "Vi du phuong thuc POST su dung Form";
//        String docType =
//                "<!doctype html public \"-//w3c//dtd html 4.0 " +
//                        "transitional//en\">\n";
//
//        out.println(docType +
//                "<html>\n" +
//                "<head><meta charset=\"UTF-8\">\n" +
//                "<title>" + title + "</title></head>\n" +
//                "<body bgcolor = \"#f0f0f0\">\n" +
//                "<h1 align = \"center\">" + title + "</h1>\n" +
//                "<ul>\n" +
//                "  <li><b>product_id</b>: "
//                + request.getParameter("product_id") + "\n" +
//                "  <li><b>name</b>: "
//                + request.getParameter("name") + "\n" +
//                "</ul>\n" +
//                "</body>" +
//                "</html>"
//        );

        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setProductId(Integer.parseInt(request.getParameter("product_id")));
        product.setPrice(Float.parseFloat(request.getParameter("price")));
        product.setDescriptionDetail(request.getParameter("description_detail"));
        product.setDescription(request.getParameter("description"));
        product.setImage(request.getParameter("image"));
        product.setCategoryId(Integer.parseInt(request.getParameter("category_id")));

        productSessionBean.create(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setImage1(request.getParameter("image1"));
        productDetail.setImage2(request.getParameter("image2"));
        productDetail.setImage3(request.getParameter("image3"));
        productDetail.setImage4(request.getParameter("image4"));
        productDetail.setImage5(request.getParameter("image5"));
        productDetail.setProductId(Integer.parseInt(request.getParameter("product_id")));
        productDetail.setInformation(request.getParameter("description_detail"));

        productDetailSessionBean.create(productDetail);
    }
}
