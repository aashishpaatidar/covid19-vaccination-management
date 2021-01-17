package io.covid19vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.covid19vms.entity.VaccinationInventory;

public interface VaccinationInventoryRepository extends JpaRepository<VaccinationInventory, Integer>{

}
