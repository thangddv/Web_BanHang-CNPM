package session_bean;

import model.Category;
import model.Product;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Stateless
public class CategorySessionBean extends AbstractSessionBean<Category> {
    @PersistenceContext(unitName = "cnpm")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorySessionBean() {
        super(Category.class);
    }

    public List<Product> getCategoryProduct(Integer categoryID) {
        return em.createQuery(
                "SELECT p FROM Product p WHERE p.categoryId = :categoryID")
                .setParameter("categoryID", categoryID)
                .getResultList();
    }

//    public List<Product> getCategoryProducts(Integer categoryID) {
//        try {
//            Context initContext = new InitialContext();
//            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/cnpm");
//            Connection connection = ds.getConnection();
//            Statement statement = connection.createStatement();
//            String sql = "Select * from product where category_id = :categoryID";
//            ResultSet resultSet = statement.executeQuery(sql);
//            List<Product> listProducts = new List<Product>();
//            while (resultSet.next()) {
//                Product p = new Product();
//                p.setCategoryId(resultSet.getInt("category_id"));
//                p.setThumbImage(resultSet.getString("thumb_image"));
//                p.setDescriptionDetail(resultSet.getString("description_detail"));
//                p.setDescription(resultSet.getString("description"));
//                p.setImage(resultSet.getString("image"));
//                p.setLastUpdate(resultSet.getTimestamp("name"));
//            }
//        } catch (SQLException ex) {
//
//        }
//    }
}
