package io.covid19vms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.covid19vms.entity.DistrictOffice;
import io.covid19vms.entity.VaccinationCentre;

public interface VaccinationCentreRepository extends JpaRepository<VaccinationCentre, Integer> {
	@Query("select c from VaccinationCentre c where c.districtOffice=null and c.district.id=:id")
	List<VaccinationCentre> getUnapprovedVaccinationCentres(@Param("id") Integer id);
	
	List<VaccinationCentre> findByDistrictOffice(DistrictOffice districtOffice);
}
