package io.covid19vms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.covid19vms.dto.ScheduleDto;
import io.covid19vms.entity.Appointment;
import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.District;
import io.covid19vms.entity.DistrictOffice;
import io.covid19vms.entity.VaccinationCentre;
import io.covid19vms.entity.VaccinationInventory;
import io.covid19vms.repository.BeneficiaryRepository;
import io.covid19vms.repository.DistrictOfficeRepository;
import io.covid19vms.repository.DistrictRepository;
import io.covid19vms.repository.VaccinationCentreRepository;

@Service
@Transactional
public class DistrictOfficeServiceImpl implements DistrictOfficeService {

	@Autowired
	private DistrictOfficeRepository repository;

	@Autowired
	private DistrictRepository districtRepo;

	@Autowired
	private BeneficiaryRepository beneficiaryRepo;

	@Autowired
	private VaccinationCentreRepository vaccinationRepo;

	@Override
	public DistrictOffice saveDistrictOffice(DistrictOffice districtOffice) {
		return repository.save(districtOffice);
	}

	@Override
	public Integer getCountOfBeneficiaries(Integer Id) {
		Optional<DistrictOffice> districtOffice = repository.findById(Id);
		List<Beneficiary> beneficiaryList = beneficiaryRepo
				.getVaccinatedCount(districtOffice.get().getDistrict().getId());
		return beneficiaryList.size();
	}

	@Override
	public List<VaccinationCentre> getUnapprovedCentres(Integer Id) {
		Optional<DistrictOffice> districtOffice = repository.findById(Id);

		return vaccinationRepo
				.getUnapprovedVaccinationCentres(districtOffice.get().getDistrict().getId());
	}

	@Override
	public VaccinationCentre updateDistrictOfficeId(Integer Id, Integer centreId) {
		Optional<VaccinationCentre> vaccinationCentre = vaccinationRepo.findById(centreId);
		Optional<DistrictOffice> districtOffice = repository.findById(Id);
		vaccinationCentre.get().setDistrictOffice(districtOffice.get());

		return vaccinationRepo.save(vaccinationCentre.get());
	}

	@Override
	public List<VaccinationCentre> getApprovedCentres(Integer Id) {
		Optional<DistrictOffice> districtOffice = repository.findById(Id);

		return vaccinationRepo.findByDistrictOffice(districtOffice.get());
	}

	@Override
	public VaccinationCentre updateInventory(Integer Id, Integer inventory) {
		Optional<VaccinationCentre> vaccinationCentre = vaccinationRepo.findById(Id);
		VaccinationInventory vaccinationInventory = vaccinationCentre.get().getInventory();
		vaccinationInventory.setCentreInventory(inventory);
		vaccinationCentre.get().addInventory(vaccinationInventory);

		return vaccinationRepo.save(vaccinationCentre.get());
	}

	@Override
	public Integer showDOInventory(Integer Id) {
		return repository.findById(Id).get().getDistrictInventory();
	}

	@Override
	public DistrictOffice updateDOInventory(Integer Id, Integer inventory) {
		Optional<DistrictOffice> districtOffice = repository.findById(Id);
		districtOffice.get().setDistrictInventory(inventory);
		return repository.save(districtOffice.get());
	}

	@Override
	public ScheduleDto scheduleAppointment(int id) {
		Appointment appointment = new Appointment();
		LocalDate localDate = null;
		int sizeCounter = 0;
		List<VaccinationCentre> centreList = vaccinationRepo.getAllVaccinationCentres(id);
		for(VaccinationCentre vc : centreList) {
			List<Beneficiary> beneficiaryList = beneficiaryRepo.findByVaccinationCentre(vc);
			int stock = vc.getInventory().getCentreInventory();
			int capacity = vc.getInventory().getCentreCapacity();

			if(stock == 0 || capacity == 0) {
				++sizeCounter;
				continue;
			}
			if(beneficiaryList.isEmpty()) {
				localDate = LocalDate.now().plusDays(7);
				appointment.setAppointmentDate(localDate);
				appointment.setActive(true);
				return new ScheduleDto(vc.getId(), appointment);
			}
			LocalDate date = beneficiaryList.stream()
					.map(o -> o.getAppointments().getAppointmentDate())
					.max(LocalDate::compareTo)
					.get();
			localDate = date;

			int count = (int) beneficiaryList.stream()
					.filter(b -> b.getAppointments().getAppointmentDate().equals(date))
					.count();
			int availableSlots = vc.getInventory().getCentreCapacity() - count;
			if (availableSlots > 0) {
				appointment.setAppointmentDate(date);
				appointment.setActive(true);
				return new ScheduleDto(vc.getId(), appointment);
			}
		}
		if(sizeCounter == centreList.size())
			return null;

		appointment.setAppointmentDate(localDate.plusDays(1));
		appointment.setActive(true);
		return new ScheduleDto(centreList.get(0).getId(), appointment);
	}

	@Override
	public Integer getCountByDistrict(Integer id) {
	
		Optional<District> district=districtRepo.findById(id);
		DistrictOffice districtOffice= repository.findByDistrict(district.get());
		return getCountOfBeneficiaries(districtOffice.getId());
		
	}

	@Override
	public List<DistrictOffice> getUnapprovedDistrictOffices() {
	
		
		return repository.findByIsApproved(false);
	}

	@Override
	public DistrictOffice updateApprovedStatus(Integer id) {
		Optional<DistrictOffice> districtOffice=repository.findById(id);
		districtOffice.get().setIsApproved(true);
		return repository.save(districtOffice.get());
	}
}
