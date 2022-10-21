package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "roles_claims")
@IdClass(RoleClaimId.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleClaim implements Serializable {

    @Id
    private UUID roleId;
    @Id
    private Long claimId;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "fk_role_claim")
    private Role role;

    @ManyToOne
    @MapsId("claimId")
    @JoinColumn(name = "fk_claim_role")
    private Claim claim;
}
