package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TBL_USERS_ROLES")
@IdClass(UserRoleId.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserRole implements Serializable {

    @Id
    @Column(name = "SQ_USER_ID")
    private UUID userId;
    @Id
    @Column(name = "SQ_ROLE_ID")
    private Long roleId;

    @MapsId("userId")
    @JoinColumn(name = "FK_USER_ROLES", referencedColumnName= "FK_USER_ROLES")
    private User user;

    @MapsId("roleId")
    @JoinColumn(name = "FK_ROLE_USERS", referencedColumnName = "FK_ROLE_USERS")
    private Role role;
}
