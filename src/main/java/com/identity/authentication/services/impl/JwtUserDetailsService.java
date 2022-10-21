package com.identity.authentication.services.impl;

import com.identity.authentication.domain.User;
import com.identity.authentication.domain.UserRole;
import com.identity.authentication.dto.UserDetailsImpl;
import com.identity.authentication.repository.UserRepository;
import com.identity.authentication.repository.UserRoleRepository;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new NotYetImplementedException();
    }

    public UsernamePasswordAuthenticationToken loadUserByUsernamePassword(String username, String password, PasswordEncoder passwordEncoder) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findUserByUsername(username);

        if(userOpt.isEmpty()) {
            throw new UsernameNotFoundException("User or Password incorrect: " + username);
        }

        User user = userOpt.get();
        System.out.println("Iniciando Verificação de Password");
        boolean verifiedPassword = passwordEncoder.matches(password, user.getPassword());
        System.out.println("Terminando Verificação de Password");
        if (user.getUsername().equals(username) && verifiedPassword) {

            List<UserRole> roleUsers = userRoleRepository.findUserRolesByUserId(user.getUserId());
            List<SimpleGrantedAuthority> roles = new ArrayList<>();

            if(!roleUsers.isEmpty()){
//                roles = roleUsers.stream()
//                        .map(userRoles -> new SimpleGrantedAuthority(userRoles.getRole().getName()))
//                        .collect(Collectors.toList());
            }


            UserDetailsImpl userDetails = UserDetailsImpl.builder()
                    .id(user.getUserId().toString())
                    .username(user.getUsername())
                    .authorities(roles)
                    .build();

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    user.getUsername(), user.getPassword(), new ArrayList<>());
            usernamePasswordAuthenticationToken.setDetails(userDetails);
            return usernamePasswordAuthenticationToken;
        } else {
            throw new UsernameNotFoundException("User or Password incorrect: " + username);
        }
    }

}
