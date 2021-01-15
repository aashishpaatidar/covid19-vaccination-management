package io.covid19vms.entity;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class State extends BaseEntity {

    @Column(name = "state_name",length = 30)
    private String stateName;

    public State() {
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

}
