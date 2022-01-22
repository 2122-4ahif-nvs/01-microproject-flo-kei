package at.flokei.entity;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HOTEL_CUSTOMER")
@UserDefinition
public class Customer extends PanacheEntityBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank!")
    @Username
    private String name;

    @Password
    @NotBlank(message = "Password cannot be blank")
    private String pw;

    @ManyToMany
    public List<MyRole> roles = new ArrayList<>();

    @Roles
    public String role;

    //region getter and setter

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<MyRole> getRoles() {
        return roles;
    }

    public void setRoles(List<MyRole> role) {
        this.roles = role;
    }

    public String getPw() {
        return pw;
    }

    //endregion

    //region constructor
    public Customer() {

    }

    public Customer(String name) {
        this.name = name;
    }
    //endregions

    public static void add(String username, String password, String role) {
        Customer user = new Customer();
        user.name = username;
        user.pw = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.persist();
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
