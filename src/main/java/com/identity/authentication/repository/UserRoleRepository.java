package com.identity.authentication.repository;

import com.identity.authentication.domain.UserRole;
import com.identity.authentication.domain.UserRoleId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, UserRoleId> {

    List<UserRole> findUserRolesByUserId(UUID userId);
}
