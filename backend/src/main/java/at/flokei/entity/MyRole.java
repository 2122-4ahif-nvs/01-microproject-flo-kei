package at.flokei.entity;

import io.quarkus.security.jpa.RolesValue;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class MyRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(mappedBy = "roles")
    public List<Customer> customers;

    @RolesValue
    public String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}