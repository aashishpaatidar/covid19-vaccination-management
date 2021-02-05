package io.covid19vms.service;

import io.covid19vms.authDto.RegisterDto;
import io.covid19vms.authDto.UserDto;
import io.covid19vms.entity.*;
import io.covid19vms.repository.DistrictRepository;
import io.covid19vms.repository.RoleRepository;
import io.covid19vms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private DistrictRepository districtRepo;

    @Autowired
    private DistrictOfficeService officeService;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private VaccinationCentreService vaccinationCentreService;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public boolean emailExists(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

    @Override
    public UserDto registerUser(RegisterDto dto) {

        UserDto user = new UserDto();
        Role role = roleRepo.findById(dto.getRoleId()).get();
        String encryptedPassword = encoder.encode(dto.getPassword());

        if(role.getRoleName().equals(RoleType.BENEFICIARY)) {
            Beneficiary beneficiary = new Beneficiary();
            beneficiary.setEmail(dto.getEmail());
            beneficiary.setPassword(encryptedPassword);
            beneficiary.setName(dto.getName());
            beneficiary.setUserRole(role);
            beneficiary.setDistrict(districtRepo.findById(dto.getDistrictId()).get());
            user.setId(beneficiaryService.saveBeneficiary(beneficiary).getId());

        }
        else if(role.getRoleName().equals(RoleType.CENTRE)) {
            VaccinationCentre vc = new VaccinationCentre();
            vc.setEmail(dto.getEmail());
            vc.setPassword(encryptedPassword);
            vc.setCentreName(dto.getName());
            vc.setUserRole(role);
            vc.setDistrict(districtRepo.findById(dto.getDistrictId()).get());
            vc.addInventory(new VaccinationInventory(0,0));
            user.setId(vaccinationCentreService.saveVaccinationCentre(vc).getId());
        }
        else {
            DistrictOffice office = new DistrictOffice();
            office.setEmail(dto.getEmail());
            office.setPassword(encryptedPassword);
            office.setOfficeName(dto.getName());
            office.setUserRole(role);
            office.setDistrict(districtRepo.findById(dto.getDistrictId()).get());
            user.setId(officeService.saveDistrictOffice(office).getId());
        }
        return user;
    }
}
