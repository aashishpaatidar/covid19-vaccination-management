package io.covid19vms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "district_office")
public class DistrictOffice extends User {

    @Column(name = "office_name", length = 30)
    private String officeName;

    @Column(name = "district_inventory")
    private int districtInventory;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address districtAddress;

    @OneToMany(mappedBy = "districtOffice")
    private List<VaccinationCentre> centres = new ArrayList<>();

    public DistrictOffice() {
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getDistrictInventory() {
        return districtInventory;
    }

    public void setDistrictInventory(int districtInventory) {
        this.districtInventory = districtInventory;
    }

    public Address getDistrictAddress() {
        return districtAddress;
    }

    public void setDistrictAddress(Address districtAddress) {
        this.districtAddress = districtAddress;
    }

    public List<VaccinationCentre> getCentres() {
        return centres;
    }

    public void setCentres(List<VaccinationCentre> centres) {
        this.centres = centres;
    }

    public void addVaccinationCentre(VaccinationCentre centre) {
        centres.add(centre);
        centre.setDistrictOffice(this);
    }
}
