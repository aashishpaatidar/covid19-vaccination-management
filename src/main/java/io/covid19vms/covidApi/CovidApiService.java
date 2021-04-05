package io.covid19vms.covidApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.covid19vms.entity.District;
import io.covid19vms.repository.DistrictOfficeRepository;
import io.covid19vms.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;


@Service
public class CovidApiService {
    @Autowired
    private CovidDataMapper api;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DistrictOfficeRepository officeRepository;

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

    public CovidDto getDistrictWiseDetails(int officeId) {
        int confirmed = 0, active = 0, deceased = 0, recovered = 0;
        int districtId = officeRepository.findById(officeId).get().getDistrict().getId();
        Optional<District> districtData = districtRepository.findById(districtId);
        String state = null, district = null;
        if(districtData.isPresent()) {
            state = districtData.get().getState().getStateName();
            district = districtData.get().getDistrictName();
        }
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

    public Set<String> getStateNames() {
        return api.jsonDataMapperApi()
                .keySet();
    }

    public Set<String> getDistrictNames(String stateName) {
        return api.jsonDataMapperApi()
                .get(stateName)
                .getDistrictData()
                .keySet();
    }

    @PostConstruct
    public void serializeHashMap() {
        try {
            FileOutputStream outputStream = new FileOutputStream("D:\\workspace\\cdac_project\\covid_map.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(api.jsonDataMapperApi());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
