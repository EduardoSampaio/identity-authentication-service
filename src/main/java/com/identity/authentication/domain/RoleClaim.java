package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TBL_ROLES_CLAIMS")
@IdClass(RoleClaimId.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleClaim implements Serializable {

    @Id
    @Column(name = "SQ_ROLE_ID")
    private UUID roleId;
    @Id
    @Column(name = "SQ_CLAIM_ID")
    private Long claimId;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "FK_ROLE_CLAIM")
    private Role role;

    @ManyToOne
    @MapsId("claimId")
    @JoinColumn(name = "FK_CLAIM_ROLE")
    private Claim claim;
}
