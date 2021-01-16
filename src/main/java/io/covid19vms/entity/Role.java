package io.covid19vms.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Column(name = "role_type")
    @Enumerated(value = EnumType.STRING)
    private RoleType roleName;

    public Role() {
    }

    public RoleType getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleType roleName) {
        this.roleName = roleName;
    }

}
