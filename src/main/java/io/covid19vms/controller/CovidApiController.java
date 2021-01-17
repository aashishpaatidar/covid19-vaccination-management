package io.covid19vms.controller;

import io.covid19vms.covidApi.CovidApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/covid")
public class CovidApiController {
    @Autowired
    private CovidApiService apiService;

    @GetMapping("/country")
    public ResponseEntity<?> getCountryDetails() {
        return new ResponseEntity<>(apiService.getCountryWiseDetails(), HttpStatus.OK);
    }

    @GetMapping("/{state}")
    public ResponseEntity<?> getStateDetails(@PathVariable("state") String state) {
        return new ResponseEntity<>(apiService.getStateWiseDetails(state), HttpStatus.OK);
    }

    @GetMapping("/{state}/{district}")
    public ResponseEntity<?> getDistrictDetails(@PathVariable("state") String state,
                                                @PathVariable("district") String district) {
        return new ResponseEntity<>(apiService.getDistrictWiseDetails(state, district), HttpStatus.OK);
    }
}
