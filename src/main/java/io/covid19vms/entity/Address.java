package io.covid19vms.entity;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Address extends BaseEntity {

    @Column(name = "address", length = 50)
    private String address;

    @ManyToOne
    @JoinColumn
    private District userDistrict;

    @OneToOne(mappedBy = "address")
    private Beneficiary beneficiary;

    @OneToOne(mappedBy = "districtAddress")
    private DistrictOffice office;

    @OneToOne(mappedBy = "centreAddress")
    private VaccinationCentre centre;

    public Address() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public District getUserDistrict() {
        return userDistrict;
    }

    public void setUserDistrict(District userDistrict) {
        this.userDistrict = userDistrict;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public DistrictOffice getOffice() {
        return office;
    }

    public void setOffice(DistrictOffice office) {
        this.office = office;
    }

    public VaccinationCentre getCentre() {
        return centre;
    }

    public void setCentre(VaccinationCentre centre) {
        this.centre = centre;
    }

    public void addBeneficiaryAddress(Beneficiary beneficiary) {
        this.setBeneficiary(beneficiary);
        beneficiary.setAddress(this);
    }

    public void addDistrictOfficeAddress(DistrictOffice office) {
        this.setOffice(office);
        office.setDistrictAddress(this);
    }

    public void addVaccinationCentreAddress(VaccinationCentre centre) {
        this.setCentre(centre);
        centre.setCentreAddress(this);
    }

}
