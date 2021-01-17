package io.covid19vms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "vaccination_centre")
public class VaccinationCentre extends User {

    @Column(name = "centre_name", length = 12)
    private String centreName;

    @OneToOne(targetEntity = District.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")
    private District district;

    @JsonIgnoreProperties("centres")
    @ManyToOne
    @JoinColumn(name = "district_office_id")
    private DistrictOffice districtOffice;

    @JsonIgnoreProperties("vaccinationCentre")
    @OneToMany(mappedBy = "vaccinationCentre")
    private List<Beneficiary> beneficiaryList = new ArrayList<>();

    @JsonIgnoreProperties("centre")
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
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
        beneficiary.setVaccinationCentre(this);
    }

    public void addInventory(VaccinationInventory inventory) {
        this.setInventory(inventory);
        inventory.setCentre(this);
    }
}
