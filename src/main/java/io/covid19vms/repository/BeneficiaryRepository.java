package io.covid19vms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.VaccinationCentre;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {
	Beneficiary findByAdhaarNumber(String aadharNumber);

	@Query("select count(*) from Beneficiary b where b.vaccinationCentre.id=:id and b.isVaccinated=true")
	int getVaccinatedCountPerCentre(@Param("id") Integer id);
	
	@Query("select count(*) from Beneficiary b where b.district.id=:id and b.isVaccinated = true")
	int getVaccinatedCount(@Param("id") Integer id);
	
	List<Beneficiary> findByVaccinationCentre(VaccinationCentre centre);

	@Query("select count(*) from Beneficiary b where b.isVaccinated = true")
	int getTotalVaccinatedCount();
	
}
