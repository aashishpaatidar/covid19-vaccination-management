package io.covid19vms.covidApi;

import java.util.Set;

public interface CovidApiService {
    CovidDto getCountryWiseDetails();
    CovidDto getStateWiseDetails(String stateName);
    CovidDto getDistrictWiseDetails(int officeId);
    Set<String> getStateList();
    Set<String> getStateNames();
    Set<String> getDistrictNames(String stateName);
    void serializeHashMap();
}
