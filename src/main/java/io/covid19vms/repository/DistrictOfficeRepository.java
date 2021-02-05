package io.covid19vms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.covid19vms.entity.District;
import io.covid19vms.entity.DistrictOffice;

public interface DistrictOfficeRepository extends JpaRepository<DistrictOffice, Integer> {
	DistrictOffice findByDistrict(District district);
	List<DistrictOffice> findByIsApproved(boolean status);
}
