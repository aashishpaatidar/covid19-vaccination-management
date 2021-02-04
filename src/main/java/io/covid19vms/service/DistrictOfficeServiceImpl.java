package io.covid19vms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.DistrictOffice;
import io.covid19vms.entity.VaccinationCentre;
import io.covid19vms.entity.VaccinationInventory;
import io.covid19vms.repository.BeneficiaryRepository;
import io.covid19vms.repository.DistrictOfficeRepository;
import io.covid19vms.repository.VaccinationCentreRepository;


@Service
@Transactional
public class DistrictOfficeServiceImpl implements DistrictOfficeService {
    @Autowired
    private DistrictOfficeRepository repository;
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
		// TODO Auto-generated method stub
		Optional<DistrictOffice> districtOffice=repository.findById(Id);
		List<Beneficiary> beneficiaryList=beneficiaryRepo.getVaccinatedCount(districtOffice.get().getDistrict().getId());
		return beneficiaryList.size();
	}

	@Override
	public List<VaccinationCentre> getUnapprovedCentres(Integer Id) {
		// TODO Auto-generated method stub
		Optional<DistrictOffice> districtOffice=repository.findById(Id);
		List<VaccinationCentre> vaccinationCentres=vaccinationRepo.getUnapprovedVaccinationCentres(districtOffice.get().getDistrict().getId());
		return vaccinationCentres;
	}

	@Override
	public VaccinationCentre updateDistrictOfficeId(Integer Id, Integer centreId) {
		// TODO Auto-generated method stub
		Optional<VaccinationCentre> vaccinationCentre=vaccinationRepo.findById(centreId);
		Optional<DistrictOffice> districtOffice=repository.findById(Id);
		vaccinationCentre.get().setDistrictOffice(districtOffice.get());
		
		return vaccinationRepo.save(vaccinationCentre.get());
	}

	@Override
	public List<VaccinationCentre> getApprovedCentres(Integer Id) {
		// TODO Auto-generated method stub
		Optional<DistrictOffice> districtOffice=repository.findById(Id);
		List<VaccinationCentre> vaccinationCentres=vaccinationRepo.findByDistrictOffice(districtOffice.get());
		
		return vaccinationCentres;
	}

	@Override
	public VaccinationCentre updateInventory(Integer Id, Integer inventory) {
		// TODO Auto-generated method stub
		Optional<VaccinationCentre> vaccinationCentre=vaccinationRepo.findById(Id);
		vaccinationCentre.get().getInventory().setCentreInventory(inventory);
		return vaccinationRepo.save(vaccinationCentre.get());
		
	}

	@Override
	public Integer showDOInventory(Integer Id) {
		// TODO Auto-generated method stub
		return repository.findById(Id).get().getDistrictInventory();
	}

	@Override
	public DistrictOffice updateDOInventory(Integer Id, Integer inventory) {
		// TODO Auto-generated method stub
		Optional<DistrictOffice> districtOffice=repository.findById(Id);
		districtOffice.get().setDistrictInventory(inventory);
		
		return repository.save(districtOffice.get());
	}
}
