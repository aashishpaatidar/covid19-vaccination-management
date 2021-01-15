package io.covid19vms.controller;

import io.covid19vms.authDto.AuthenticationRequest;
import io.covid19vms.authDto.UserDto;
import io.covid19vms.repository.UserRepository;
import io.covid19vms.security.MyUserDetailsService;
import io.covid19vms.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest request) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
                request.getPassword()));
        if(auth.isAuthenticated()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
            UserDto dto = new UserDto(userRepo.findByEmail(request.getEmail()), jwtUtils.generateToken(userDetails));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>("Unauthorized request",HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> fetchUsers() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

}
