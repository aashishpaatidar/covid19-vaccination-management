package io.covid19vms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.VaccinationCentre;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {
	Beneficiary findByAdhaarNumber(String aadharNumber);
	List<Beneficiary> findByVaccinationCentre(VaccinationCentre vaccinationCentre);
}
