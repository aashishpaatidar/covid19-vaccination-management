package io.covid19vms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "beneficiary")
public class Beneficiary extends User {

	@Column(length = 50)
	private String name;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer age;

	@Column(name = "is_vaccinated")
	private Boolean isVaccinated=false;

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
	@OneToOne(mappedBy = "beneficiary", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BeneficiaryFeedback feedback;

	@JsonIgnoreProperties("beneficiary")
	@OneToOne(mappedBy = "beneficiary", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Appointment appointment;

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

	public void addBeneficiaryFeedback(BeneficiaryFeedback feedback) {
		this.setFeedback(feedback);
		feedback.setBeneficiary(this);
	}

	public void addAppointments(Appointment appointment) {
		this.setAppointments(appointment);
		appointment.setBeneficiary(this);
	}
	
}
