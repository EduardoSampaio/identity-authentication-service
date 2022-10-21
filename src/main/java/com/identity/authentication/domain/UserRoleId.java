package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
public class UserRoleId implements Serializable {

    @Column(name = "SQ_USER_ID")
    private UUID userId;
    @Column(name = "SQ_ROLE_ID")
    private Long roleId;

    public UserRoleId(){}
    public UserRoleId(UUID userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
