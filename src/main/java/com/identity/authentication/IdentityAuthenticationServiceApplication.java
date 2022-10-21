package com.identity.authentication;

import com.identity.authentication.domain.Role;
import com.identity.authentication.domain.User;
import com.identity.authentication.repository.RoleRepository;
import com.identity.authentication.repository.UserRepository;
import com.identity.authentication.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class IdentityAuthenticationServiceApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(IdentityAuthenticationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = User.builder().username("admin").email("eduardo@gmail.com")
                .password(passwordEncoder.encode("admin"))
                .appKey(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        if(this.userRepository.findUserByUsername("admin").isEmpty()){
            this.userRepository.save(user);
        }

        Role.builder().name("root").description("Acesso Total").build();
    }
}
