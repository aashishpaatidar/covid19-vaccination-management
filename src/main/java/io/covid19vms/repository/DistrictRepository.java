package io.covid19vms.repository;

import io.covid19vms.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Query("select d from District d where d.state.id = :stateId")
    List<District> findByState(int stateId);
}
