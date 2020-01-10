package session_bean;

import model.CustomerOrder;
import model.OrderedProduct;
import model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;
import java.util.List;

@Stateless
public class OrderSessionBean extends AbstractSessionBean<CustomerOrder> {
    @PersistenceContext(unitName = "cnpm")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderSessionBean() {
        super(CustomerOrder.class);
    }

//    public List<Product> getCategoryProduct(Integer categoryID) {
//        return em.createQuery(
//                "SELECT p FROM Product p WHERE p.categoryId = :categoryID")
//                .setParameter("categoryID", categoryID)
//                .getResultList();
//    }

    public CustomerOrder getLastOrder() {
        List<CustomerOrder> res = em.createQuery(
                "SELECT o FROM CustomerOrder o WHERE o.orderId = (SELECT max(o.orderId) from CustomerOrder o)")
                .getResultList();
        return res.get(0);
    }
}
