package io.covid19vms.service;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.BeneficiaryFeedback;

public interface BeneficiaryService {
	Beneficiary applyForVaccination(Beneficiary beneficiary, Integer id);

	Beneficiary saveFeedback(BeneficiaryFeedback feedback, Integer id);

	Beneficiary saveBeneficiary(Beneficiary beneficiary);
	
	Beneficiary getAppointment(Integer id);

	int getVaccinatedCountByCountry();
}
