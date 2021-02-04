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

import io.covid19vms.service.DistrictOfficeService;

@RequestMapping("/district_office")
@RestController
@CrossOrigin
public class DistrictOfficeController {
		
		@Autowired
		private DistrictOfficeService districtService;
	
	
	@GetMapping("/reports/{id}")
	public ResponseEntity<?> getTotalVaccinatedCount(@PathVariable Integer id)
	{
		try {
			return new  ResponseEntity<>(districtService.getCountOfBeneficiaries(id),HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/applications/{id}")
	public ResponseEntity<?> getListOfVaccinationCentres(@PathVariable Integer id)
	{
		try {
			return new ResponseEntity<>(districtService.getUnapprovedCentres(id),HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}	


	@PutMapping("/applications/{id}")
	public ResponseEntity<?> updateDistrictId(@PathVariable Integer id,@RequestBody Integer centreId)
	{
		try {
			districtService.updateDistrictOfficeId(id, centreId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}	
	
	@GetMapping("/centres/{id}")
	public ResponseEntity<?> getListOfCentres(@PathVariable Integer id)
	{
		try {
			return new ResponseEntity<>(districtService.getApprovedCentres(id),HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/centres") 
	public ResponseEntity<?> updateInventory(@RequestParam Integer inventory,@RequestBody Integer centreId)
	{
		try {
			districtService.updateInventory(centreId, inventory);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/inventory/{id}")
	public ResponseEntity<?> showInventory(@PathVariable Integer id)
	{
		try {
			return new ResponseEntity<>(districtService.showDOInventory(id),HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@PutMapping("/inventory/{id}")
	public ResponseEntity<?> updateDistrictInventory(@PathVariable Integer id,@RequestBody Integer inventory)
	{
		try {
			districtService.updateDOInventory(id, inventory);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
