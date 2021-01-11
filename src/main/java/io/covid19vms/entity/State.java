package io.covid19vms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "state")
public class State extends BaseEntity {

    @Column(name = "state_name",length = 30)
    private String stateName;

    @OneToMany(mappedBy = "state")
    private List<District> districts = new ArrayList<>();

    public State() {
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public void addDistrict(District district) {
        districts.add(district);
        district.setState(this);
    }
}
