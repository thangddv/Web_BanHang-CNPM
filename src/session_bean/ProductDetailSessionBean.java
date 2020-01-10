package session_bean;

import model.ProductDetail;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductDetailSessionBean extends AbstractSessionBean<ProductDetail> {
    @PersistenceContext(unitName = "cnpm")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductDetailSessionBean() {
        super(ProductDetail.class);
    }

    public ProductDetail getDetailProduct(String productID) {
        Integer proID = Integer.parseInt(productID);
        List<ProductDetail> res = em.createQuery(
                "SELECT p FROM ProductDetail p WHERE p.productId = :productID")
                .setParameter("productID", proID)
                .getResultList();
        return res.get(0);
    }
}
