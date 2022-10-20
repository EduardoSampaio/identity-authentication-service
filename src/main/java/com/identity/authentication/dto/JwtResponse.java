package com.identity.authentication.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private String token;
    private String refeshToken;
    private String username;
    private String id;
    private List<String> roles = new ArrayList<>();
}
