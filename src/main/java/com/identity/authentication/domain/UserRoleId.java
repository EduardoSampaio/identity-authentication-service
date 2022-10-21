package com.identity.authentication.domain;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleId implements Serializable {

    private UUID userId;
    private Long roleId;
}
