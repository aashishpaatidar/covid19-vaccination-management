package io.covid19vms.controller;

import io.covid19vms.service.DropDownListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/lists")
public class DropDownListController {
    @Autowired
    private DropDownListService listService;

    @GetMapping("/state_list")
    public ResponseEntity<?> getAllStates() {
        return ResponseEntity.ok(listService.getAllState());
    }

    @GetMapping("/district_list/{stateId}")
    private ResponseEntity<?> getDistrictsStateWise(@PathVariable("stateId") int stateId) {
        return ResponseEntity.ok(listService.getDistrictByState(stateId));
    }
}
