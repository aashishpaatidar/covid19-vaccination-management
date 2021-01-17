package io.covid19vms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;

    @Column(name = "is_active")
    private boolean isActive;

    @JsonIgnoreProperties("appointments")
    @OneToOne
    @JoinColumn(name = "beneficiary_id")
    private Beneficiary beneficiary;

    public Appointment() {
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }
}
