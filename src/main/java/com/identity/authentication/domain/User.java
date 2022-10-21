package com.identity.authentication.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TBL_USERS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {

    @Id
    @Column(name = "SQ_USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(name = "TXT_USERNAME" , nullable = false, length = 30)
    private String username;
    @Column(name = "TXT_PASSWORD" , nullable = false, length = 50)
    private String password;
    @Column(name = "TXT_EMAIL" , nullable = false,  length = 50)
    private String email;
    @Column(name = "TXT_PHONE" , nullable = true, length = 20)
    private String phone;
    @Column(name = "TXT_APP_KEY" , length = 100)
    private String appKey;
    @Column(name = "BL_ISLOCKED" , nullable = false)
    private Boolean isLocked;
    @Column(name = "BL_TWOFACTORYAUTHENTICATION" , nullable = false)
    private Boolean twoFactoryAuthentication;
    @Column(name = "DT_CREATE_AT", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;
    @Column(name = "DT_UPDATE_AT", columnDefinition = "TIMESTAMP")
    private LocalDateTime updateAt;
}
