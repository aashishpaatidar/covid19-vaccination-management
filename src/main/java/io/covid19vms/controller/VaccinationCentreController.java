package io.covid19vms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.covid19vms.service.VaccinationCentreService;

@CrossOrigin
@RestController
@RequestMapping("/vaccination_centre")
public class VaccinationCentreController {

	@Autowired
	private VaccinationCentreService service;

	@GetMapping("/inventory/{id}")
	public ResponseEntity<?> getCapacityAndStock(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(service.getCapacityAndStock(id), HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/inventory/capacity/{id}")
	public ResponseEntity<?> updateCapacity(@PathVariable Integer id, @RequestBody Integer capacity) {
		try {

			return new ResponseEntity<>(service.updateCapacity(id, capacity), HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/inventory/stock/{id}")
	public ResponseEntity<?> updateStock(@PathVariable Integer id, @RequestBody Integer Stock) {
		try {
			return new ResponseEntity<>(service.updateStock(id, Stock), HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/request/{id}")
	public ResponseEntity<?> getDetailsByAadhar(@PathVariable Integer id, @RequestParam String adhaarNumber) {
		try {
			return new ResponseEntity<>(service.getDetailsByAadhar(id, adhaarNumber), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/request/status")
	public ResponseEntity<?> updateStatus(@RequestParam String adhaarNumber) {
		try {
			service.updateStatus(adhaarNumber);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/reports/{id}")
	public ResponseEntity<?> getReports(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(service.getBeneficiaryReports(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<?> getFeedback(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(service.getBeneficairyFeedbackList(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
