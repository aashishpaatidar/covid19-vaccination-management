package io.covid19vms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "district_user_request")
public class DistrictUserRequest extends BaseEntity {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "request_date")
    private LocalDate requestDate;

    @Column(name = "request_status")
    private boolean requestStatus;

    @JsonIgnoreProperties("request")
    @OneToOne
    @JoinColumn(name = "beneficiary_id")
    private Beneficiary districtBeneficiary;

    public DistrictUserRequest() {
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public boolean isRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Beneficiary getDistrictBeneficiary() {
        return districtBeneficiary;
    }

    public void setDistrictBeneficiary(Beneficiary districtBeneficiary) {
        this.districtBeneficiary = districtBeneficiary;
    }
}
