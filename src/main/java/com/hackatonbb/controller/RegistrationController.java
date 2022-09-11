package com.hackatonbb.controller;

import com.hackatonbb.OperationStatus;
import com.hackatonbb.resource.user.registration.RegistrationService;
import com.hackatonbb.resource.user.registration.model.RegistrationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/auth/sign-up")
    public ResponseEntity<OperationStatus> registration(@RequestBody @Valid RegistrationDTO registrationDTO) {
        return new ResponseEntity<>(registrationService.registerUser(registrationDTO), HttpStatus.CREATED);
    }
}
