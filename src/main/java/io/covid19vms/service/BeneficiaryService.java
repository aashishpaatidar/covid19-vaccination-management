package io.covid19vms.service;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.BeneficiaryFeedback;

public interface BeneficiaryService {
	Beneficiary updateBeneficiaryRecord(Beneficiary beneficiary, Integer id);

	BeneficiaryFeedback saveFeedback(BeneficiaryFeedback feedback, Integer id);

	Beneficiary saveBeneficiary(Beneficiary beneficiary);
}
