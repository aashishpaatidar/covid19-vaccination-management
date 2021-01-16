package io.covid19vms.repository;

import io.covid19vms.entity.DistrictOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictOfficeRepository extends JpaRepository<DistrictOffice, Integer> {
}
