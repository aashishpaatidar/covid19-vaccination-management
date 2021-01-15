package io.covid19vms.covidApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StateData {
    private Map<String, DistrictData> districtData = new HashMap<>();
    private String statecode;

    public StateData() {
    }

    public Map<String, DistrictData> getDistrictData() {
        return districtData;
    }

    public void setDistrictData(Map<String, DistrictData> districtData) {
        this.districtData = districtData;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }
}
