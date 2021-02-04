package io.covid19vms.service;

import java.util.List;

import io.covid19vms.entity.DistrictOffice;
import io.covid19vms.entity.VaccinationCentre;

public interface DistrictOfficeService {
    DistrictOffice saveDistrictOffice(DistrictOffice districtOffice);
    Integer getCountOfBeneficiaries(Integer Id);
    List<VaccinationCentre> getUnapprovedCentres(Integer Id);
    VaccinationCentre updateDistrictOfficeId(Integer Id,Integer centreId);
    List<VaccinationCentre> getApprovedCentres(Integer Id);
    VaccinationCentre updateInventory(Integer Id,Integer inventory);
    Integer showDOInventory(Integer Id);
    DistrictOffice updateDOInventory(Integer Id,Integer inventory);
}
