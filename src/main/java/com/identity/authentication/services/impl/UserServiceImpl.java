package com.identity.authentication.services.impl;

import com.identity.authentication.dto.JwtRequest;
import com.identity.authentication.dto.JwtResponse;
import com.identity.authentication.dto.UserDetailsImpl;
import com.identity.authentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public JwtResponse authenticate(JwtRequest authenticationRequest) throws Exception {
        UserDetailsImpl userDetails = authenticateManager(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return JwtResponse.builder()
                .username(userDetails.getUsername())
                .token(token)
                .refeshToken(UUID.randomUUID().toString())
                .id(UUID.randomUUID().toString())
                .roles(userDetails.getAuthorities().stream()
                        .map(role -> role.getAuthority())
                        .collect(Collectors.toList()))
                .build();
    }

    private UserDetailsImpl authenticateManager(String username, String password) throws Exception {
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
