package io.covid19vms.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "user",
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String password;

    @Column(name = "name", length = 50)
    private String userName;

    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="id")
    )
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Role userRole;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public void addRole(Role role) {
        this.setUserRole(role);
        role.setRoleName(this.getUserRole().getRoleName());
    }
}
