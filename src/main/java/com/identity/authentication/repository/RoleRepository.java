package com.identity.authentication.repository;

import com.identity.authentication.domain.Role;
import com.identity.authentication.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
