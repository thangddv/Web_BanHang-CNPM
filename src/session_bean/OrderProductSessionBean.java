package session_bean;

import model.OrderedProduct;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderProductSessionBean extends AbstractSessionBean<OrderedProduct> {
    @PersistenceContext(unitName = "cnpm")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderProductSessionBean() {
        super(OrderedProduct.class);
    }

//    public List<Product> getCategoryProduct(Integer categoryID) {
//        return em.createQuery(
//                "SELECT p FROM Product p WHERE p.categoryId = :categoryID")
//                .setParameter("categoryID", categoryID)
//                .getResultList();
//    }
}
