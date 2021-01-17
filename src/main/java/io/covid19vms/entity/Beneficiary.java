package io.covid19vms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "beneficiary")
public class Beneficiary extends User {

	@Column(length = 20)
	private String name;

	private Integer age;

	@Column(name = "is_vaccinated")
	private Boolean isVaccinated;

	@Column(name = "adhaar_no", length = 12, unique = true)
	private String adhaarNumber;

	@JsonIgnoreProperties("beneficiaryList")
	@ManyToOne
	@JoinColumn(name = "centre_id")
	private VaccinationCentre vaccinationCentre;

	@OneToOne(targetEntity = District.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "district_id")
	private District district;

	@JsonIgnoreProperties("beneficiary")
	@OneToOne(mappedBy = "beneficiary", fetch = FetchType.LAZY)
	private BeneficiaryFeedback feedback;

	@JsonIgnoreProperties("beneficiary")
	@OneToOne(mappedBy = "beneficiary", fetch = FetchType.LAZY)
	private Appointment appointment;

	@JsonIgnoreProperties("districtBeneficiary")
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

	public VaccinationCentre getVaccinationCentre() {
		return vaccinationCentre;
	}

	public void setVaccinationCentre(VaccinationCentre vaccinationCentre) {
		this.vaccinationCentre = vaccinationCentre;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public BeneficiaryFeedback getFeedback() {
		return feedback;
	}

	public void setFeedback(BeneficiaryFeedback feedback) {
		this.feedback = feedback;
	}

	public Appointment getAppointments() {
		return appointment;
	}

	public void setAppointments(Appointment appointments) {
		this.appointment = appointments;
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
		//appointment.add(appointment);
		appointment.setBeneficiary(this);
	}

	public void addDistrictUserRequest(DistrictUserRequest request) {
		this.setRequest(request);
		request.setDistrictBeneficiary(this);
	}

}
