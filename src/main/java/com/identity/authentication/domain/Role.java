package com.identity.authentication.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "TBL_ROLES")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SQ_ROLE_ID")
    private Long roleId;
    @Column(name = "TXT_NAME", nullable = false, length = 30)
    private String name;
    @Column(name = "TXT_DESCRIPTION", nullable = false, length = 50)
    private String description;

    @OneToMany(mappedBy="role",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy="role",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<RoleClaim> roleClaims;

}
