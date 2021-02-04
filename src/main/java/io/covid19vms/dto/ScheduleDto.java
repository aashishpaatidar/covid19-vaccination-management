package io.covid19vms.dto;

import io.covid19vms.entity.Appointment;

public class ScheduleDto {
    private int centreId;
    private Appointment appointment;

    public ScheduleDto(int centreId, Appointment appointment) {
        this.centreId = centreId;
        this.appointment = appointment;
    }

    public int getCentreId() {
        return centreId;
    }

    public void setCentreId(int centreId) {
        this.centreId = centreId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
