package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TBL_USERS_CLAIMS")
@IdClass(UserClaimId.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserClaim implements Serializable {

    @Id
    @Column(name = "SQ_USER_ID")
    private UUID userId;
    @Id
    @Column(name = "SQ_CLAIM_ID")
    private Long claimId;

    @ManyToOne
    @JoinColumn(name = "SQ_USER_ID", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "SQ_CLAIM_ID", insertable = false, updatable = false)
    private Claim claim;
}
