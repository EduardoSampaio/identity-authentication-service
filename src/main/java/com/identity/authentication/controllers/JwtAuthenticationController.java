package com.identity.authentication.controllers;

import com.identity.authentication.dto.JwtRequest;
import com.identity.authentication.dto.JwtResponse;
import com.identity.authentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        JwtResponse jwtResponse = userService.authenticate(authenticationRequest);
        return ResponseEntity.ok(jwtResponse);
    }

}
