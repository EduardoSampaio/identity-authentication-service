package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @OneToMany(mappedBy="role",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy="role",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<RoleClaim> roleClaims;
}
