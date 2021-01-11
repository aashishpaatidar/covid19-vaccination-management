package io.covid19vms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "beneficiary")
public class Beneficiary extends User {

    @Column(length = 20)
    private String name;

    private int age;

    @Column(name = "is_vaccinated")
    private boolean isVaccinated;

    @Column(name = "adhaar_no", length = 12, unique = true)
    private String adhaarNumber;

    @ManyToOne
    @JoinColumn(name = "centre_id")
    private VaccinationCentre vaccinationCentre;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(mappedBy = "beneficiary", fetch = FetchType.LAZY)
    private BeneficiaryFeedback feedback;

    @OneToMany(mappedBy = "beneficiary", fetch = FetchType.LAZY)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToOne(mappedBy = "districtBeneficiary", fetch = FetchType.LAZY)
    private DistrictUserRequest request;

    public Beneficiary() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getAdhaarNumber() {
        return adhaarNumber;
    }

    public void setAdhaarNumber(String adhaarNumber) {
        this.adhaarNumber = adhaarNumber;
    }

    public VaccinationCentre getCentre() {
        return vaccinationCentre;
    }

    public void setCentre(VaccinationCentre centre) {
        this.vaccinationCentre = centre;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BeneficiaryFeedback getFeedback() {
        return feedback;
    }

    public void setFeedback(BeneficiaryFeedback feedback) {
        this.feedback = feedback;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public DistrictUserRequest getRequest() {
        return request;
    }

    public void setRequest(DistrictUserRequest request) {
        this.request = request;
    }

    public void addBeneficiaryFeedback(BeneficiaryFeedback feedback) {
        this.setFeedback(feedback);
        feedback.setBeneficiary(this);
    }

    public void addAppointments(Appointment appointment) {
        appointments.add(appointment);
        appointment.setBeneficiary(this);
    }

    public void addDistrictUserRequest(DistrictUserRequest request) {
        this.setRequest(request);
        request.setDistrictBeneficiary(this);
    }

}
