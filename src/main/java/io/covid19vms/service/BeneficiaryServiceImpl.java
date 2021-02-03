package io.covid19vms.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.BeneficiaryFeedback;
import io.covid19vms.entity.DistrictUserRequest;
import io.covid19vms.repository.BeneficiaryRepository;

@Service
@Transactional
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private BeneficiaryRepository beneficiaryRepo;

	@Autowired
	private DistrictUserRequestService districtUserService;

	@Override
	public Beneficiary applyForVaccination(Beneficiary beneficiary, Integer id) {
		Optional<Beneficiary> optionalBeneficiary = beneficiaryRepo.findById(id);
		optionalBeneficiary.ifPresent(b -> {
			DistrictUserRequest request = new DistrictUserRequest();
			request.setRequestDate(LocalDate.now());
			request.setDistrictBeneficiary(optionalBeneficiary.get());
			districtUserService.saveDistrictUserRequest(request);
			b.setAdhaarNumber(beneficiary.getAdhaarNumber());
			b.setAge(beneficiary.getAge());
		});
		return beneficiaryRepo.save(optionalBeneficiary.get());
	}

	@Override
	public Beneficiary saveFeedback(BeneficiaryFeedback feedback, Integer id) {
		Optional<Beneficiary> optionalBeneficiary = beneficiaryRepo.findById(id);
		optionalBeneficiary.ifPresent(beneficiary -> beneficiary.addBeneficiaryFeedback(feedback));
		return beneficiaryRepo.save(optionalBeneficiary.get());
	}

	@Override
	public Beneficiary saveBeneficiary(Beneficiary beneficiary) {
		return beneficiaryRepo.save(beneficiary);
	}
}
