package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(name = "username" , nullable = false, length = 30)
    private String username;
    @Column(name = "password" , nullable = false, length = 30)
    private String password;
    @Column(name = "email" , nullable = false,  length = 30)
    private String email;
    @Column(name = "phone" , nullable = true, length = 30)
    private String phone;
    @Column(name = "appKey" , nullable = false,  length = 30)
    private String appKey;
    @Column(name = "isLocked" , nullable = false)
    private Boolean isLocked;
    @Column(name = "twoFactoryAuthentication" , nullable = false)
    private Boolean twoFactoryAuthentication;
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;
    @Column(name = "updateAt", columnDefinition = "TIMESTAMP")
    private LocalDateTime updateAt;

    @OneToMany(mappedBy="user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy="user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserClaim> userClaims;
}
