package io.covid19vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.covid19vms.entity.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {

}
