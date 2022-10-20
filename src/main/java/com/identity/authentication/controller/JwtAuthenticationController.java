package com.identity.authentication.controller;

import com.identity.authentication.dto.JwtRequest;
import com.identity.authentication.dto.JwtResponse;
import com.identity.authentication.dto.UserDetailsImpl;
import com.identity.authentication.service.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        UserDetailsImpl userDetails = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final String token = jwtTokenUtil.generateToken(userDetails);

        JwtResponse jwtResponse = JwtResponse.builder()
                .username(userDetails.getUsername())
                .token(token)
                .refeshToken(UUID.randomUUID().toString())
                .id(UUID.randomUUID().toString())
                .roles(userDetails.getAuthorities().stream()
                        .map(role -> role.getAuthority())
                        .collect(Collectors.toList()))
                .build();

        return ResponseEntity.ok(jwtResponse);
    }

    private UserDetailsImpl authenticate(String username, String password) throws Exception {
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return (UserDetailsImpl) authenticate.getDetails();
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
