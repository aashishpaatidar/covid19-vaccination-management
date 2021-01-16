package io.covid19vms.service;

import io.covid19vms.entity.DistrictOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictOfficeService {
    DistrictOffice saveDistrictOffice(DistrictOffice districtOffice);
}
