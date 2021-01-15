package io.covid19vms.covidApi;

import java.io.IOException;
import java.util.HashMap;

public interface CovidDataMapper {
    HashMap<String, StateData> jsonDataMapperApi();
}
