package io.covid19vms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "district")
public class District extends BaseEntity {

    @Column(name = "district_name", length = 30)
    private String districtName;

    @OneToMany(mappedBy = "userDistrict")
    private List<Address> addresses = new ArrayList<>();

    @ManyToOne
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUserDistrict(this);
    }
}
