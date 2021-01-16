package io.covid19vms.service;

import io.covid19vms.entity.DistrictOffice;
import io.covid19vms.repository.DistrictOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DistrictOfficeServiceImpl implements DistrictOfficeService {
    @Autowired
    private DistrictOfficeRepository repository;

    @Override
    public DistrictOffice saveDistrictOffice(DistrictOffice districtOffice) {
        return repository.save(districtOffice);
    }
}
