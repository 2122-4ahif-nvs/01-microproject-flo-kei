package at.flokei.control;

import at.flokei.entity.Customer;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class Startup {
    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        // reset and load all test users
        Customer.add("admin", "admin", "admin");
        Customer.add("user", "user", "user");
    }
}
