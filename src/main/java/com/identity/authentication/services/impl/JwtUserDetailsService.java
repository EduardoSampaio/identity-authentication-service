package com.identity.authentication.services.impl;

import com.identity.authentication.dto.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    String username = "admin";
    String password = "admin";

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equalsIgnoreCase(username)) {
            return UserDetailsImpl.builder()
                    .username(username)
                    .password(password)
                    .id(UUID.randomUUID().toString())
                    .authorities(new ArrayList<>())
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UsernamePasswordAuthenticationToken loadUserByUsernamePassword(String username, String password) throws UsernameNotFoundException {
        UserDetailsImpl userDetails = loadUserByUsername(username);
        if (userDetails.getUsername().equalsIgnoreCase(username) && userDetails.getPassword().equalsIgnoreCase(password)) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    username, password, new ArrayList<>());
            usernamePasswordAuthenticationToken.setDetails(userDetails);
            return usernamePasswordAuthenticationToken;
        } else {
            throw new UsernameNotFoundException("User or Password incorrect: " + username);
        }
    }

}
