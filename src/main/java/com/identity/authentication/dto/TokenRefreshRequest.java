package com.identity.authentication.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TokenRefreshRequest  implements Serializable {
    private String refreshToken;
}
