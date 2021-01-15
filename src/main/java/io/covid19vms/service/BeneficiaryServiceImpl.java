package io.covid19vms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.repository.BeneficiaryRepository;

@Service
@Transactional
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private BeneficiaryRepository beneficiaryRepo;

	@Override
	public Beneficiary updateBeneficiaryRecord(Beneficiary beneficiary, Integer id) {
		Beneficiary returnedBeneficiary = null;
		Optional<Beneficiary> optionalBeneficiary = beneficiaryRepo.findById(id);
		if (optionalBeneficiary.isPresent()) {
			returnedBeneficiary = optionalBeneficiary.get();
			returnedBeneficiary.setAdhaarNumber(beneficiary.getAdhaarNumber());
			returnedBeneficiary.setAge(beneficiary.getAge());
		}
		return beneficiaryRepo.save(returnedBeneficiary);
	}
}
