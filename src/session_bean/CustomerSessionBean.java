package session_bean;

import model.Customer;
import model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CustomerSessionBean extends AbstractSessionBean<Customer> {
    @PersistenceContext(unitName = "cnpm")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerSessionBean() {
        super(Customer.class);
    }

    public Customer findCustomer(String account, String password) {
        try {
            List<Customer> res = em.createQuery(
                    "Select c from Customer c where c.account = :account and c.password = :password")
                    .setParameter("account", account)
                    .setParameter("password", password)
                    .getResultList();
            return res.get(0);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Customer findCustomerByUser(String account) {
        return (Customer) em.createQuery(
                "Select c from Customer c where c.account = :account ")
                .setParameter("account", account)
                .getResultList();

    }

    public List<Customer> getAllCustomers() {
        List<Customer> res = em.createQuery(
                "SELECT c FROM Customer c WHERE c.customerId <> 0")
                .getResultList();
        return res;
    }

}
