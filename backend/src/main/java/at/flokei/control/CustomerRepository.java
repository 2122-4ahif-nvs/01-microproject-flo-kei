package at.flokei.control;

import at.flokei.entity.Booking;
import at.flokei.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Customer save(Customer customer) {
        return em.merge(customer);
    }

    public List<Customer> getAll() {
        var query = em.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Transactional
    public Customer addCustomer(Customer customer) {
        return em.merge(customer);
    }
}
