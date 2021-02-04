package io.covid19vms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.VaccinationCentre;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {
	Beneficiary findByAdhaarNumber(String aadharNumber);

	List<Beneficiary> findByVaccinationCentre(VaccinationCentre vaccinationCentre);
	
	@Query("select b from Beneficiary b where b.district.id=:id and b.isVaccinated=true")
	List<Beneficiary> getVaccinatedCount(@Param("id") Integer id);
	

}
