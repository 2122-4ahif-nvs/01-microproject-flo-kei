package at.flokei.entity;

import at.flokei.control.CustomerRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class CustomerTest {
    @Inject
    EntityManager em;

    @Inject
    Logger logger;

    @Inject
    CustomerRepository customerRepository;

    @Test
    void createCustomer() {
        Customer customer = new Customer("Mike");

        Customer c2 = customerRepository.save(customer);
        System.out.println(c2);
        if (c2.getId() == null) {
            fail();
        }
    }
}