package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users_roles")
@IdClass(UserRole.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserRole implements Serializable {

    @Id
    private UUID userId;
    @Id
    private Long roleId;

    @ManyToOne
    @JoinColumn(name = "fk_users_roles")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_roles_users")
    private Role role;
}
