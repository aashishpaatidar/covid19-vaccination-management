package io.covid19vms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "district")
public class District extends BaseEntity {

    @Column(name = "district_name", length = 30)
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
