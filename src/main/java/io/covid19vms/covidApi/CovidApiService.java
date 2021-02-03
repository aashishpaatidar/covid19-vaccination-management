package io.covid19vms.covidApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


@Service
public class CovidApiService {
    @Autowired
    private CovidDataMapper api;

    public CovidDto getCountryWiseDetails() {
        int confirmed = 0, active = 0, deceased = 0, recovered = 0;
        confirmed = api.jsonDataMapperApi()
                .values()
                .stream()
                .mapToInt(i -> i.getDistrictData()
                        .values()
                        .stream()
                        .map(DistrictData::getConfirmed)
                        .reduce(0, Integer::sum)).sum();
        active = api.jsonDataMapperApi()
                .values()
                .stream()
                .mapToInt(i -> i.getDistrictData()
                        .values()
                        .stream()
                        .map(DistrictData::getActive)
                        .reduce(0, Integer::sum)).sum();
        deceased = api.jsonDataMapperApi()
                .values()
                .stream()
                .mapToInt(i -> i.getDistrictData()
                        .values()
                        .stream()
                        .map(DistrictData::getDeceased)
                        .reduce(0, Integer::sum)).sum();
        recovered = api.jsonDataMapperApi()
                .values()
                .stream()
                .mapToInt(i -> i.getDistrictData()
                        .values()
                        .stream()
                        .map(DistrictData::getRecovered)
                        .reduce(0, Integer::sum)).sum();

        return new CovidDto(active, confirmed, deceased, recovered);
    }

    public CovidDto getStateWiseDetails(String stateName) {
        int confirmed = 0, active = 0, deceased = 0, recovered = 0;
        confirmed = api.jsonDataMapperApi()
                .get(stateName)
                .getDistrictData()
                .values()
                .stream()
                .mapToInt(DistrictData::getConfirmed)
                .sum();
        active = api.jsonDataMapperApi()
                .get(stateName)
                .getDistrictData()
                .values()
                .stream()
                .mapToInt(DistrictData::getActive)
                .sum();
        deceased = api.jsonDataMapperApi()
                .get(stateName)
                .getDistrictData()
                .values()
                .stream()
                .mapToInt(DistrictData::getDeceased)
                .sum();
        recovered = api.jsonDataMapperApi()
                .get(stateName)
                .getDistrictData()
                .values()
                .stream()
                .mapToInt(DistrictData::getRecovered)
                .sum();

        return new CovidDto(active, confirmed, deceased, recovered);
    }

    public CovidDto getDistrictWiseDetails(String state, String district) {
        int confirmed = 0, active = 0, deceased = 0, recovered = 0;
        confirmed = api.jsonDataMapperApi()
                .get(state)
                .getDistrictData()
                .get(district)
                .getConfirmed();
        active = api.jsonDataMapperApi()
                .get(state)
                .getDistrictData()
                .get(district)
                .getActive();
        deceased = api.jsonDataMapperApi()
                .get(state)
                .getDistrictData()
                .get(district)
                .getDeceased();
        recovered = api.jsonDataMapperApi()
                .get(state)
                .getDistrictData()
                .get(district)
                .getRecovered();

        return new CovidDto(active, confirmed, deceased, recovered);
    }

    public Set<String> getStateList() {
        return new TreeSet<>(api.jsonDataMapperApi().keySet());
    }
}
