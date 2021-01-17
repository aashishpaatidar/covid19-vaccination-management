package io.covid19vms.controller;

import io.covid19vms.authDto.RegisterDto;
import io.covid19vms.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<?> userSignUp(@RequestBody RegisterDto dto) {
        try {
            if (registerService.emailExists(dto.getEmail()))
                return new ResponseEntity<>("Email already exists", HttpStatus.FORBIDDEN);

            return ResponseEntity.ok(registerService.registerUser(dto));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
