package session_bean;

import model.Product;
import model.ProductDetail;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.PreparedStatement;
import java.util.List;

@Stateless
public class ProductSessionBean extends AbstractSessionBean<Product> {
    @PersistenceContext(name = "cnpm")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductSessionBean() {
        super(Product.class);
    }

    public Product getProduct(String productID) {
        Integer proID = Integer.parseInt(productID);
        List<Product> res = em.createQuery(
                "SELECT p FROM Product p WHERE p.productId = :productID")
                .setParameter("productID", proID)
                .getResultList();
        return res.get(0);
    }


    public List<Product> getAllProducts() {
        List<Product> res = em.createQuery(
                "SELECT p FROM Product p WHERE p.productId <> 0")
                .getResultList();
        return res;
    }

    public List<Product> getProductsByName(String name) {
        List<Product> res = em.createQuery(
                "SELECT p FROM Product p WHERE p.name like '%"+name+"%'")
                .getResultList();
        return res;
    }

    public List<Product> getProductsByPrice(String min, String max) {
        List<Product> res = em.createQuery(
                "SELECT p FROM Product p WHERE p.price between "+min+" and "+max+"")
                .getResultList();
        return res;
    }

    public List<Product> getTopProducts() {
        List<Product> res = em.createQuery(
                "SELECT p FROM Product p WHERE p.productId <> 0")
                .setMaxResults(8)
                .getResultList();
        return res;
    }

    public List<Product> getSellerProducts() {
        List<Product> res = em.createQuery(
                "SELECT p FROM Product p WHERE p.productId <> 0 AND p.price<1500 ORDER BY p.price DESC ")
                .setMaxResults(8)
                .getResultList();
        return res;
    }
}