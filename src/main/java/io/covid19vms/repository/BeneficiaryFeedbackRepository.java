package io.covid19vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.covid19vms.entity.BeneficiaryFeedback;

public interface BeneficiaryFeedbackRepository extends JpaRepository<BeneficiaryFeedback, Integer> {

}
