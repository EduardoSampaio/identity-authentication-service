package com.identity.authentication.domain;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleClaimId implements Serializable {

    private Long roleId;
    private Long claimId;
}
