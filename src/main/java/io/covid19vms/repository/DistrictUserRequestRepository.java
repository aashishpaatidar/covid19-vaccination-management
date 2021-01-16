package io.covid19vms.repository;

import io.covid19vms.entity.DistrictUserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictUserRequestRepository extends JpaRepository<DistrictUserRequest, Integer> {
    @Query("select r from DistrictUserRequest r where r.districtBeneficiary.district.id = :id")
    List<DistrictUserRequest> getRequestedUsers(@Param("id") int id);
}
