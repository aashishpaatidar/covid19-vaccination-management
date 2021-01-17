package io.covid19vms.dto;

public class VaccinationCentreFeedbackDto {
	private String aadharNumber;
	private String name;
	private int daysSinceVaccination;
	private String status;
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDaysSinceVaccination() {
		return daysSinceVaccination;
	}
	public VaccinationCentreFeedbackDto(String aadharNumber, String name, int daysSinceVaccination, String status) {
		super();
		this.aadharNumber = aadharNumber;
		this.name = name;
		this.daysSinceVaccination = daysSinceVaccination;
		this.status = status;
	}
	public void setDaysSinceVaccination(int daysSinceVaccination) {
		this.daysSinceVaccination = daysSinceVaccination;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
