package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "claims")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Claim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SQ_CLAIM_ID")
    private Long roleId;
    @Column(name = "TXT_NAME", nullable = false, length = 30)
    private String name;
    @Column(name = "TXT_DESCRIPTION", nullable = false, length = 50)
    private String description;

    @OneToMany(mappedBy="claim",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserClaim> userClaims;

    @OneToMany(mappedBy="claim",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<RoleClaim> roleClaims;
}
