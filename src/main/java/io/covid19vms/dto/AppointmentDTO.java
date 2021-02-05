package io.covid19vms.dto;

public class AppointmentDTO {
	private String appointmentDate;
	private String centreName;
	private String districtName;

	public AppointmentDTO(String appointmentDate, String centreName, String districtName) {
		super();
		this.appointmentDate = appointmentDate;
		this.centreName = centreName;
		this.districtName = districtName;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
