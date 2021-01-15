package io.covid19vms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "beneficiary_feedback")
public class BeneficiaryFeedback extends BaseEntity {

    @Column(name = "adverse_effect", length = 50)
    private String adverseEffect;

    @Column(length = 200)
    private String details;

    @JsonIgnoreProperties("feedback")
    @OneToOne
    @JoinColumn(name = "beneficiary_id")
    private Beneficiary beneficiary;

    public BeneficiaryFeedback() {
    }

    public String getAdverseEffect() {
        return adverseEffect;
    }

    public void setAdverseEffect(String adverseEffect) {
        this.adverseEffect = adverseEffect;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }


}
