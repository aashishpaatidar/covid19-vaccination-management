package io.covid19vms.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "district_user_request")
public class DistrictUserRequest extends BaseEntity {

    @Column(name = "request_date")
    private LocalDate requestDate;

    @Column(name = "request_status")
    private boolean requestStatus;

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
