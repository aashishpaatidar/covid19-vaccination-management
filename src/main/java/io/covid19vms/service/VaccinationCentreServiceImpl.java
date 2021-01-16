package io.covid19vms.service;

import io.covid19vms.entity.VaccinationCentre;
import io.covid19vms.repository.VaccinationCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VaccinationCentreServiceImpl implements VaccinationCentreService {
    @Autowired
    private VaccinationCentreRepository repository;

    @Override
    public VaccinationCentre saveVaccinationCentre(VaccinationCentre vaccinationCentre) {
        return repository.save(vaccinationCentre);
    }
}
