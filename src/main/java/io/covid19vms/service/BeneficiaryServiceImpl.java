package io.covid19vms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.BeneficiaryFeedback;
import io.covid19vms.repository.BeneficiaryFeedbackRepository;
import io.covid19vms.repository.BeneficiaryRepository;

@Service
@Transactional
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private BeneficiaryRepository beneficiaryRepo;

	@Autowired
	private BeneficiaryFeedbackRepository feedbackRepo;

	@Override
	public Beneficiary updateBeneficiaryRecord(Beneficiary beneficiary, Integer id) {
		Beneficiary returnedBeneficiary = new Beneficiary();
		Optional<Beneficiary> optionalBeneficiary = beneficiaryRepo.findById(id);
		if (optionalBeneficiary.isPresent()) {
			returnedBeneficiary = optionalBeneficiary.get();
			returnedBeneficiary.setAdhaarNumber(beneficiary.getAdhaarNumber());
			returnedBeneficiary.setAge(beneficiary.getAge());
		}
		return beneficiaryRepo.save(returnedBeneficiary);
	}

	@Override
	public BeneficiaryFeedback saveFeedback(BeneficiaryFeedback feedback, Integer id) {
		Beneficiary returnedBeneficiary = null;
		Optional<Beneficiary> optionalBeneficiary = beneficiaryRepo.findById(id);
		if (optionalBeneficiary.isPresent()) {
			returnedBeneficiary = optionalBeneficiary.get();
			feedback.setBeneficiary(returnedBeneficiary);
		}
		return feedbackRepo.save(feedback);
	}

	@Override
	public Beneficiary saveBeneficiary(Beneficiary beneficiary) {
		return beneficiaryRepo.save(beneficiary);
	}
}
