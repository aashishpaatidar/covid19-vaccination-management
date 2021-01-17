package io.covid19vms.service;

import io.covid19vms.entity.District;
import io.covid19vms.entity.State;

import java.util.List;

public interface DropDownListService {
    List<State> getAllState();
    List<District> getDistrictByState(int stateId);
}
