package io.covid19vms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vaccination_centre")
public class VaccinationCentre extends User {

    @Column(name = "centre_name", length = 12)
    private String centreName;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address centreAddress;

    @ManyToOne
    @JoinColumn(name = "district_office_id")
    private DistrictOffice districtOffice;

    @OneToMany(mappedBy = "vaccinationCentre")
    private List<Beneficiary> beneficiaryList = new ArrayList<>();

    @OneToOne(mappedBy = "centre")
    private VaccinationInventory inventory;

    public VaccinationCentre() {
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public List<Beneficiary> getBeneficiaryList() {
        return beneficiaryList;
    }

    public void setBeneficiaryList(List<Beneficiary> beneficiaryList) {
        this.beneficiaryList = beneficiaryList;
    }

    public Address getCentreAddress() {
        return centreAddress;
    }

    public void setCentreAddress(Address centreAddress) {
        this.centreAddress = centreAddress;
    }

    public VaccinationInventory getInventory() {
        return inventory;
    }

    public void setInventory(VaccinationInventory inventory) {
        this.inventory = inventory;
    }

    public DistrictOffice getDistrictOffice() {
        return districtOffice;
    }

    public void setDistrictOffice(DistrictOffice districtOffice) {
        this.districtOffice = districtOffice;
    }

    public void addBeneficiary(Beneficiary beneficiary) {
        beneficiaryList.add(beneficiary);
        beneficiary.setCentre(this);
    }

    public void addInventory(VaccinationInventory inventory) {
        this.setInventory(inventory);
        inventory.setCentre(this);
    }
}
