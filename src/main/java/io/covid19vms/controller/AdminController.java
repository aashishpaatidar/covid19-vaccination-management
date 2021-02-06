package io.covid19vms.controller;

import io.covid19vms.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.covid19vms.service.DistrictOfficeService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private DistrictOfficeService districtService;

	@Autowired
	private BeneficiaryService beneficiaryService;

	
	@GetMapping("/reports")
	public ResponseEntity<?> getReports(@RequestParam Integer id) {
			try {
				return new ResponseEntity<>(districtService.getCountByDistrict(id),HttpStatus.OK);
			}
			catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
	@GetMapping("/applications")
	public ResponseEntity<?> getDistrictOfficeApplications()
	{
		try {
			return new ResponseEntity<>(districtService.getUnapprovedDistrictOffices(),HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/applications")
	public ResponseEntity<?> updateStatus(@RequestBody Integer id) {
		try {
			districtService.updateApprovedStatus(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}

	@GetMapping("/vaccinated_count")
	public ResponseEntity<?> getVaccinatedCount() {
		try {
			return ResponseEntity.ok(beneficiaryService.getVaccinatedCountByCountry());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
