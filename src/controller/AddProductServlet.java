package controller;

import model.Product;
import session_bean.ProductSessionBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class AddProductServlet extends HttpServlet {

    @EJB
    private ProductSessionBean productSessionBean;

    private static final long serialVersionUID = 1L;

    public static final String SAVE_DIRECTORY = "images";

    public AddProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        for (Part part : request.getParts()) {
//            String fileName = extractFileName(part);
//            String image = "images/" + fileName;
//            if (fileName != null && fileName.length() > 0) {
//                /*                    String filePath = fullSavePath + File.separator + fileName;*/
//                /*                    part.write(filePath);*/
//                Product product = new Product();
//                product.setName(request.getParameter("name"));
//                product.setPrice(Integer.parseInt(request.getParameter("price")));
//                product.setDescription(request.getParameter("description"));
//                product.setDescriptionDetail(request.getParameter("description_detail"));
//                product.setImage(image);
//                productSessionBean.create(product);
//            }
//        }
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("tables.jsp");
//        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setPrice(Integer.parseInt(request.getParameter("price")));
        product.setDescription(request.getParameter("description"));
        product.setDescriptionDetail(request.getParameter("description_detail"));
        product.setImage("images/1add.jpg");
        product.setCategoryId(2);
        productSessionBean.create(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tables.jsp");
        dispatcher.forward(request, response);
    }


    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }
}