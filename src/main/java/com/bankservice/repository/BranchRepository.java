package com.bankservice.repository;

import com.bankservice.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    Optional<Branch> findByBranchName(String branchName);
    Optional<Branch> findByLocation(String location);
}
