package io.covid19vms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import io.covid19vms.dto.ScheduleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.BeneficiaryFeedback;
import io.covid19vms.repository.BeneficiaryRepository;

@Service
@Transactional
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private BeneficiaryRepository beneficiaryRepo;

	@Autowired
	private DistrictOfficeService officeService;

	@Autowired
	private VaccinationCentreService vaccinationCentreService;

	@Override
	public Beneficiary applyForVaccination(Beneficiary beneficiary, Integer id) {
		Optional<Beneficiary> optionalBeneficiary = beneficiaryRepo.findById(id);
		if(optionalBeneficiary.isPresent()) {
			optionalBeneficiary.get().setAdhaarNumber(beneficiary.getAdhaarNumber());
			optionalBeneficiary.get().setAge(beneficiary.getAge());
			ScheduleDto dto = officeService.scheduleAppointment(optionalBeneficiary.get()
					.getDistrict().getId());

			if(dto == null)
				return null;

			vaccinationCentreService.saveBeneficiary(optionalBeneficiary.get(), dto.getCentreId());
			optionalBeneficiary.get().addAppointments(dto.getAppointment());
		}
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

	@Override
	public Beneficiary getAppointment(Integer id) {
		return beneficiaryRepo.findById(id).get();
	}

	@Override
	public int getVaccinatedCountByCountry() {
		return beneficiaryRepo.getTotalVaccinatedCount();
	}
}
