package session_bean;

import model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerSeesionBean extends AbstractSessionBean<Customer>{
    @PersistenceContext(unitName = "cnpm")
    private static EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerSeesionBean() {
        super(Customer.class);
    }

    public static Customer findCustomer(String account, String password) {
        return (Customer) em.createQuery(
                "Select c from Customer c where c.account = :account and c.password = :password")
                .setParameter("account", account)
                .getResultList();

    }

    public Customer findCustomerByUser(String account) {
        return (Customer) em.createQuery(
                "Select c from Customer c where c.account = :account ")
                .setParameter("account", account)
                .getResultList();

    }

}
