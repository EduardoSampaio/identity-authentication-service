package com.identity.authentication.services;

import com.identity.authentication.dto.JwtRequest;
import com.identity.authentication.dto.JwtResponse;


public interface UserService {

    JwtResponse authenticate(JwtRequest authenticationRequest) throws Exception;
}
