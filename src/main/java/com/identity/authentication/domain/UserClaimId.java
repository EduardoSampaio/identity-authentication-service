package com.identity.authentication.domain;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserClaimId implements Serializable {

    private UUID userId;
    private Long claimId;
}
