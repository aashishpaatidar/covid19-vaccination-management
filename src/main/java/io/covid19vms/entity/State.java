package io.covid19vms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "state")
public class State extends BaseEntity {

    @Column(name = "state_name", length = 50)
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
