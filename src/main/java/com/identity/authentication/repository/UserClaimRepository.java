package com.identity.authentication.repository;

import com.identity.authentication.domain.RoleClaim;
import com.identity.authentication.domain.RoleClaimId;
import com.identity.authentication.domain.UserClaimId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClaimRepository extends PagingAndSortingRepository<RoleClaim, UserClaimId> {
}
