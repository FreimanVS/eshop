package com.freimanvs.shops.eshop.entities;

import com.freimanvs.shops.eshop.entities.interfaces.Idable;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Email;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "eshop")
public class User implements Idable, Serializable {

    @ApiParam(value = "id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ApiParam(value = "login", required = true)
    @NotBlank
    @Size(min = 4, max = 50)
    @Column(name="login", unique = true)
    private String login;

    @ApiParam(value = "password", required = true)
    @NotBlank
    @Size(min = 4, max = 200)
    @Column(name="password")
    private String password;

    @ApiParam(value = "email", required = true)
    @Email
    @Column(name="email")
    private String email;

    @JsonbTransient
    @OneToOne(mappedBy = "user")
    private Order order;

    @ApiParam(value = "roles")
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
