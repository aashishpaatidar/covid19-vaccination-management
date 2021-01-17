package io.covid19vms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.covid19vms.entity.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {
	Beneficiary findByAdhaarNumber(String aadharNumber);
	List<Beneficiary> findByVaccinationCentre(Integer id);
}
