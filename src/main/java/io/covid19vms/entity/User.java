package io.covid19vms.entity;

import javax.persistence.*;

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

    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="id")
    )
    @OneToOne(fetch = FetchType.EAGER)
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

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }
}
