package io.covid19vms.service;

import io.covid19vms.entity.Beneficiary;

public interface BeneficiaryService {
	Beneficiary updateBeneficiaryRecord(Beneficiary beneficiary, Integer id);
}
