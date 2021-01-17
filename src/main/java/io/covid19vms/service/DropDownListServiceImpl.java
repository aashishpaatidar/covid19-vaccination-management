package io.covid19vms.service;

import io.covid19vms.entity.District;
import io.covid19vms.entity.State;
import io.covid19vms.repository.DistrictRepository;
import io.covid19vms.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DropDownListServiceImpl implements DropDownListService {
    @Autowired
    private StateRepository stateRepo;

    @Autowired
    private DistrictRepository districtRepo;

    @Override
    public List<State> getAllState() {
        return stateRepo.findAll();
    }

    @Override
    public List<District> getDistrictByState(int stateId) {
        return districtRepo.findByState(stateId);
    }
}
