package io.covid19vms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.BeneficiaryFeedback;
import io.covid19vms.service.BeneficiaryService;

@CrossOrigin
@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {

	@Autowired
	private BeneficiaryService beneficiaryService;

	@PostMapping("/apply_for_vaccination/{id}")
	public ResponseEntity<?> applyForVaccination(@PathVariable Integer id, @RequestBody Beneficiary beneficiary) {
		System.out.println(beneficiary.getAdhaarNumber());
		try {
			return new ResponseEntity<>(beneficiaryService.updateBeneficiaryRecord(beneficiary, id),
					HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/feedback/{id}")
	public ResponseEntity<?> saveFeedbackDetails(@PathVariable Integer id, @RequestBody BeneficiaryFeedback feedback) {
		try {
			return new ResponseEntity<>(beneficiaryService.saveFeedback(feedback, id), HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
