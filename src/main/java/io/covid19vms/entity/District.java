package io.covid19vms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "district")
public class District extends BaseEntity {

    @Column(name = "district_name", length = 50)
    private String districtName;

    @ManyToOne(targetEntity = State.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private State state;

    public District() {
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
