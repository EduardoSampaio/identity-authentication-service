package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users_claims")
@IdClass(UserClaimId.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserClaim implements Serializable {

    @Id
    private UUID userId;
    @Id
    private Long claimId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "fk_users_claims")
    private User user;

    @ManyToOne
    @MapsId("claimId")
    @JoinColumn(name = "fk_claims_users")
    private Claim claim;
}
