package io.covid19vms.service;

import java.util.List;

import io.covid19vms.dto.VaccinationCentreFeedbackDto;
import io.covid19vms.dto.VaccinationCentreRequestDto;
import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.VaccinationCentre;
import io.covid19vms.entity.VaccinationInventory;

public interface VaccinationCentreService {
    VaccinationCentre saveVaccinationCentre(VaccinationCentre vaccinationCentre);
    VaccinationCentreRequestDto getDetailsByAadhar(Integer id,String aadharNumber);
    Integer updateCapacity(Integer id,Integer capacity);
    Integer updateStock(Integer id,Integer stock);
    VaccinationInventory getCapacityAndStock(Integer id);
    Integer getBeneficiaryReports(Integer id);
    List<VaccinationCentreFeedbackDto> getBeneficairyFeedbackList(Integer id);
    Beneficiary updateStatus(String aadharNumber);
    
    
}
