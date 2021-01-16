package io.covid19vms.service;

import io.covid19vms.authDto.RegisterDto;
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
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private DistrictRepository districtRepo;

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
    public User registerUser(RegisterDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setUserRole(roleRepo.findById(dto.getRoleId()).get());
        User u = userService.saveUserDetails(user);

        if(user.getUserRole().getRoleName().equals(RoleType.BENEFICIARY)) {
            Beneficiary beneficiary = new Beneficiary();
            beneficiary.setId(u.getId());
            beneficiary.setName(dto.getName());
            beneficiary.setAge(50);
            beneficiary.setDistrict(districtRepo.findById(dto.getDistrictId()).get());
            beneficiaryService.saveBeneficiary(beneficiary);
        }
        else if(user.getUserRole().getRoleName().equals(RoleType.CENTRE)) {
            VaccinationCentre vc = new VaccinationCentre();
            vc.setId(u.getId());
            vc.setCentreName(dto.getName());
            vc.setDistrict(districtRepo.findById(dto.getDistrictId()).get());
            vaccinationCentreService.saveVaccinationCentre(vc);
        }
        else {
            DistrictOffice office = new DistrictOffice();
            office.setId(u.getId());
            office.setOfficeName(dto.getName());
            office.setDistrict(districtRepo.findById(dto.getDistrictId()).get());
        }
        return user;
    }
}
