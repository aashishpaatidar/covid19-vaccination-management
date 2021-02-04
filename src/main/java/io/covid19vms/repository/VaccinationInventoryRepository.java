package io.covid19vms.repository;

import io.covid19vms.entity.VaccinationCentre;
import org.springframework.data.jpa.repository.JpaRepository;

import io.covid19vms.entity.VaccinationInventory;

public interface VaccinationInventoryRepository extends JpaRepository<VaccinationInventory, Integer>{
    VaccinationInventory findByCentre(VaccinationCentre centre);
}
