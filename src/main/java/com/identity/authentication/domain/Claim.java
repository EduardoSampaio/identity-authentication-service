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
    private Long roleId;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @OneToMany(mappedBy="claim",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserClaim> userClaims;

    @OneToMany(mappedBy="role",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<RoleClaim> roleClaims;
}
