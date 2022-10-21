package com.identity.authentication.repository;

import com.identity.authentication.domain.Claim;
import com.identity.authentication.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends PagingAndSortingRepository<Claim, Long> {
}
