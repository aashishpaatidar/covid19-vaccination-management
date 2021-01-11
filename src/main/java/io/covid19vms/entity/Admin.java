package io.covid19vms.entity;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends User {

    @Column(name = "name", length = 50)
    private String adminName;

    public Admin() {
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
