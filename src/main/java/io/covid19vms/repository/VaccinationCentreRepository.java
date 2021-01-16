package io.covid19vms.repository;

import io.covid19vms.entity.VaccinationCentre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCentreRepository extends JpaRepository<VaccinationCentre, Integer> {
}
